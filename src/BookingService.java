import Enums.BookingStatusEnum;
import Enums.PaymentStatusEnum;
import Enums.VehicleStatusEnum;
import Product.Booking;
import Product.User;
import Product.Vehicle;
import Strategy.BookingStrategy.BookingStrategy;
import Strategy.PaymentStrategy.PaymentStrategy;
import Strategy.PricingStrategy.PricingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class BookingService {
    BookingServiceRepo bookingServiceRepo=new BookingServiceRepo();

    public Booking bookVehicle(List<Vehicle> vehicleList, User user, int bookingId,
                               LocalDateTime startTime, LocalDateTime endTime, int forDistance,
                               BookingStrategy bookingStrategy, PricingStrategy pricingStrategy,
                               PaymentStrategy paymentStrategy){

        // Step 1: BookingStrategy decides the order in which vehicles are offered
        List<Vehicle> orderedVehicles = bookingStrategy.bookingAlgorithm(vehicleList);

        // Step 2: reserve the first free vehicle; compareAndSet(false,true) returns
        // true only for the thread that actually wins the reservation
        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : orderedVehicles) {
            if (vehicle.getVehicleStatusEnum() == VehicleStatusEnum.AVALIABLE
                    && vehicle.getIsBooked().compareAndSet(false, true)) {
                selectedVehicle = vehicle;
                break;
            }
        }
        if (selectedVehicle == null) {
            System.out.println("No vehicle available for booking " + bookingId);
            return null;
        }

        // Step 3: PricingStrategy decides the amount
        double amount = pricingStrategy.calculatePrice(selectedVehicle, startTime, endTime, forDistance);

        // Step 4: PaymentStrategy (via PaymentProcessor) collects it
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
        boolean paid = paymentProcessor.pay(amount);
        if (!paid) {
            // payment failed -> release the reserved vehicle, else it stays booked forever
            selectedVehicle.getIsBooked().set(false);
            System.out.println("Payment failed for booking " + bookingId);
            return null;
        }

        // Step 5: payment succeeded -> mark vehicle rented and persist the booking
        selectedVehicle.setRentedCount(selectedVehicle.getRentedCount()+1);
        selectedVehicle.setVehicleStatusEnum(VehicleStatusEnum.RENTED);

        Booking booking=new Booking(bookingId, selectedVehicle, BookingStatusEnum.BOOKED, PaymentStatusEnum.PAID, user);
        booking.setBookingAmount((int) amount);
        bookingServiceRepo.createBooking(booking);
        return booking;
    }

    public boolean returnVehicle(int bookingId){
        Booking booking = bookingServiceRepo.findAndCloseBooking(bookingId);
        if (booking == null) {
            return false;
        }
        Vehicle vehicle = booking.getVehicle();
        vehicle.setVehicleStatusEnum(VehicleStatusEnum.AVALIABLE);
        vehicle.getIsBooked().set(false);
        return true;
    }

}

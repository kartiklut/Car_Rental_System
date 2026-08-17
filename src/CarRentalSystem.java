import Enums.VehicleStatusEnum;
import Enums.VehicleTypeEnum;
import Product.*;
import Strategy.BookingStrategy.CheapestFirstBookingStrategy;
import Strategy.BookingStrategy.LeastRentedBookingStrategy;
import Strategy.PaymentStrategy.CreditCardPaymentStartegy;
import Strategy.PaymentStrategy.UPIPaymentStrategy;
import Strategy.PricingStrategy.DistancePricingStrategy;
import Strategy.PricingStrategy.TimePricingStartegy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class CarRentalSystem {

    public static void main(String[] args) {

        //Create user
        User user=new User(1234,"Kartik Luthra",9873261);

        //create Vehicles
        Vehicle car1=new Vehicle(1,12345, VehicleTypeEnum.CAR, VehicleStatusEnum.AVALIABLE,0,1000);
        Vehicle car2=new Vehicle(2,87865, VehicleTypeEnum.CAR, VehicleStatusEnum.AVALIABLE,0,2000);

        //Create Location and Store
        Location location=new Location(123,121001,"Gurugram","Haryana");
        Store store=new Store(001,location,new ArrayList<>(Arrays.asList(car1,car2)));

        BookingService bookingService=new BookingService();

        //Booking 1: cheapest vehicle, time-based pricing, paid via UPI
        LocalDateTime startTime=LocalDateTime.now();
        LocalDateTime endTime=startTime.plusHours(5);
        Booking booking1=bookingService.bookVehicle(store.getStoreAvlVehicleList(), user, 1,
                startTime, endTime, 0,
                new CheapestFirstBookingStrategy(), new TimePricingStartegy(), new UPIPaymentStrategy());
        if(booking1!=null){
            System.out.println("Booking 1 done: vehicle "+booking1.getVehicle().getVehicle_id()
                    +" amount Rs."+booking1.getBookingAmount());
            bookingService.returnVehicle(booking1.getBookingId());
        }

        //Booking 2: least rented vehicle, distance-based pricing, paid via Credit Card
        Booking booking2=bookingService.bookVehicle(store.getStoreAvlVehicleList(), user, 2,
                startTime, endTime, 150,
                new LeastRentedBookingStrategy(), new DistancePricingStrategy(), new CreditCardPaymentStartegy());
        if(booking2!=null){
            System.out.println("Booking 2 done: vehicle "+booking2.getVehicle().getVehicle_id()
                    +" amount Rs."+booking2.getBookingAmount());
            bookingService.returnVehicle(booking2.getBookingId());
        }

        //Return vehicle of booking 1 and book again -> should get the same car back
        bookingService.returnVehicle(1);
        Booking booking3=bookingService.bookVehicle(store.getStoreAvlVehicleList(), user, 3,
                startTime, endTime, 0,
                new CheapestFirstBookingStrategy(), new TimePricingStartegy(), new UPIPaymentStrategy());
        if(booking3!=null){
            System.out.println("Booking 3 done: vehicle "+booking3.getVehicle().getVehicle_id()
                    +" amount Rs."+booking3.getBookingAmount());
            bookingService.returnVehicle(booking3.getBookingId());
        }


    }
}

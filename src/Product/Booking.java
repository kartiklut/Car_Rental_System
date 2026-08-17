package Product;

import Enums.BookingStatusEnum;
import Enums.PaymentStatusEnum;

import java.util.concurrent.atomic.AtomicBoolean;

public class Booking {

    private int bookingId;
    private Vehicle vehicle;
    private BookingStatusEnum bookingStatusEnum;
    private PaymentStatusEnum paymentStatusEnum;
    private User user;
    private int bookingAmount;


    public Booking(int bookingId, Vehicle vehicle, BookingStatusEnum bookingStatusEnum, PaymentStatusEnum paymentStatusEnum,User user) {
        this.bookingId = bookingId;
        this.vehicle = vehicle;
        this.bookingStatusEnum = bookingStatusEnum;
        this.paymentStatusEnum = paymentStatusEnum;
        this.user=user;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BookingStatusEnum getBookingStatusEnum() {
        return bookingStatusEnum;
    }

    public void setBookingStatusEnum(BookingStatusEnum bookingStatusEnum) {
        this.bookingStatusEnum = bookingStatusEnum;
    }

    public PaymentStatusEnum getPaymentStatusEnum() {
        return paymentStatusEnum;
    }

    public void setPaymentStatusEnum(PaymentStatusEnum paymentStatusEnum) {
        this.paymentStatusEnum = paymentStatusEnum;
    }

}

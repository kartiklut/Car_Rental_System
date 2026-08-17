import Enums.BookingStatusEnum;
import Product.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingServiceRepo {
    Map<Integer, Booking> bookings=new HashMap<>();

    // returns the closed Booking so the caller can free its vehicle, null if not found
    Booking findAndCloseBooking(int bookingId){
        if(bookings.containsKey(bookingId)){
           Booking booking= bookings.get(bookingId);
           booking.setBookingStatusEnum(BookingStatusEnum.CLOSE);
           bookings.remove(booking.getBookingId());
           return booking;
        }
        return null;
    }

    boolean createBooking(Booking booking){
        if(!bookings.containsKey(booking.getBookingId())){
            bookings.put(booking.getBookingId(), booking);
            return true;
        }
        return false;
    }


}

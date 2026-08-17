package Strategy.BookingStrategy;

import Product.Vehicle;

import java.util.List;

public interface BookingStrategy {

    List<Vehicle>  bookingAlgorithm(List<Vehicle> vehicleList);

}

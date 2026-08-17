package Strategy.BookingStrategy;

import Product.Vehicle;

import java.util.Collections;
import java.util.List;

public class CheapestFirstBookingStrategy implements  BookingStrategy{


    @Override
    public List<Vehicle> bookingAlgorithm(List<Vehicle> vehicleList) {
        Collections.sort(vehicleList,(a,b)->{
            return a.getVehicleBasePrice()-b.getVehicleBasePrice();
        });
        return vehicleList;
    }

}

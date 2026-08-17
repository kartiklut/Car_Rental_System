package Strategy.PricingStrategy;

import Product.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimePricingStartegy implements PricingStrategy{

    @Override
    public double calculatePrice(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, int kmDriven) {
        long hours = Math.max(1, Duration.between(startTime, endTime).toHours());
        return hours*vehicle.getVehicleBasePrice();
    }
}

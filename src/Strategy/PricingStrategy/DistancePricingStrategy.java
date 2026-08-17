package Strategy.PricingStrategy;

import Product.Vehicle;

import java.time.LocalDateTime;

public class DistancePricingStrategy implements PricingStrategy{

    @Override
    public double calculatePrice(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, int kmDriven) {
        return kmDriven*vehicle.getVehicleBasePrice();
    }

}

package Strategy.PricingStrategy;

import Product.Vehicle;

import java.time.LocalDateTime;

public interface PricingStrategy {

    double calculatePrice(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime,int kmDriven);
}

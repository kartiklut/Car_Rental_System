package Product;

import Enums.VehicleStatusEnum;
import Enums.VehicleTypeEnum;

import java.util.concurrent.atomic.AtomicBoolean;


public class Vehicle {

    private int vehicle_id;
    private int chasisNumber;
    private VehicleTypeEnum vehicleTypeEnum;
    private VehicleStatusEnum vehicleStatusEnum;
    private int rentedCount;
    private int vehicleBasePrice;
    private AtomicBoolean isBooked = new AtomicBoolean(false);

    public AtomicBoolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(AtomicBoolean isBooked) {
        this.isBooked = isBooked;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(int chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }

    public VehicleStatusEnum getVehicleStatusEnum() {
        return vehicleStatusEnum;
    }

    public void setVehicleStatusEnum(VehicleStatusEnum vehicleStatusEnum) {
        this.vehicleStatusEnum = vehicleStatusEnum;
    }

    public int getRentedCount() {
        return rentedCount;
    }

    public void setRentedCount(int rentedCount) {
        this.rentedCount = rentedCount;
    }

    public int getVehicleBasePrice() {
        return vehicleBasePrice;
    }

    public void setVehicleBasePrice(int vehicleBasePrice) {
        this.vehicleBasePrice = vehicleBasePrice;
    }

    public Vehicle(int vehicle_id, int chasisNumber, VehicleTypeEnum vehicleTypeEnum, VehicleStatusEnum vehicleStatusEnum, int rentedCount, int vehicleBasePrice) {
        this.vehicle_id = vehicle_id;
        this.chasisNumber = chasisNumber;
        this.vehicleTypeEnum = vehicleTypeEnum;
        this.vehicleStatusEnum = vehicleStatusEnum;
        this.rentedCount = rentedCount;
        this.vehicleBasePrice = vehicleBasePrice;
    }
}

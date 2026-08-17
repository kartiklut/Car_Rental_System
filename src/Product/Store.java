package Product;

import java.util.List;

public class Store {

    private int storeId;
    private Location location;
    private List<Vehicle> storeAvlVehicleList;

    public Store(int storeId, Location location, List<Vehicle> storeAvlVehicleList) {
        this.storeId = storeId;
        this.location = location;
        this.storeAvlVehicleList = storeAvlVehicleList;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Vehicle> getStoreAvlVehicleList() {
        return storeAvlVehicleList;
    }

    public void setStoreAvlVehicleList(List<Vehicle> storeAvlVehicleList) {
        this.storeAvlVehicleList = storeAvlVehicleList;
    }
}

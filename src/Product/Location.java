package Product;

public class Location {

    private int locationId;
    private int zipCode;
    private String city;
    private String state;

    public Location(int locationId, int zipCode, String city, String state) {
        this.locationId = locationId;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

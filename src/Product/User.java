package Product;

import java.util.List;

public class User {

    private int userId;
    private String userName;
    private int drivingLicense;

    public User(int userId, String userName, int drivingLicense) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicense = drivingLicense;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(int drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}

package Project.pojo;

public class Seat {
    private String location;
    private String state;
    private String useruse;
    private String username;

    public Seat() {}

    public Seat(String location, String state, String useruse, String username) {
        this.location = location;
        this.state = state;
        this.useruse = useruse;
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUseruse(String useruse) {
        this.useruse = useruse;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    public String getUseruse() {
        return useruse;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "location='" + location + '\'' +
                ", state='" + state + '\'' +
                ", useruse='" + useruse + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

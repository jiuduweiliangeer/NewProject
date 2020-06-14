package Project.pojo;

public class Seat {
    private String location;
    private String state;

    public Seat() {}

    public Seat(String location, String state) {
        this.location = location;
        this.state = state;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "location='" + location + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

package Project.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Dastine {
    private String username;
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date opentime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date closetime;
    private String state;

    public Dastine() {}

    public Dastine(String username, String location, Date opentime, Date closetime, String state) {
        this.username = username;
        this.location = location;
        this.opentime = opentime;
        this.closetime = closetime;
        this.state = state;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

    public Date getOpentime() {
        return opentime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Dastine{" +
                "username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", opentime=" + opentime +
                ", closetime=" + closetime +
                ", state='" + state + '\'' +
                '}';
    }
}

package Project.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class History {
    private String username;
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String operate;

    public History() {}

    public History(String username, String location, Date date, String operate) {
        this.username = username;
        this.location = location;
        this.date = date;
        this.operate = operate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getOperate() {
        return operate;
    }

    @Override
    public String toString() {
        return "History{" +
                "username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", operate='" + operate + '\'' +
                '}';
    }
}

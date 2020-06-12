package Project.pojo;

import javax.validation.constraints.Email;

public class User {
    private String username;
    private String password;
    @Email(message = "请输入正确的邮箱")
    private String email;
    private Integer stuID;
    private String gender;
    private String major;
    private String stuclass;
    private String teaID;

    public User() {}

    public User(String username, String password, @Email(message = "请输入正确的邮箱") String email, Integer stuID, String gender, String major, String stuclass, String teaID) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.stuID = stuID;
        this.gender = gender;
        this.major = major;
        this.stuclass = stuclass;
        this.teaID = teaID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getStuID() {
        return stuID;
    }

    public String getGender() {
        return gender;
    }

    public String getMajor() {
        return major;
    }

    public String getStuclass() {
        return stuclass;
    }

    public String getTeaID() {
        return teaID;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", stuID=" + stuID +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", stuclass='" + stuclass + '\'' +
                ", teaID='" + teaID + '\'' +
                '}';
    }
}

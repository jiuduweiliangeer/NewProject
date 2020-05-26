package Project.dao;

import Project.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean Login(String username,String password){
        String sql="SELECT password FROM studentuser WHERE username=?";
        try {
            String passwordresult=jdbcTemplate.queryForObject(sql,String.class,username);
            boolean s=password.equals(passwordresult);
            return s;
        }catch (Exception e){
            boolean s=false;
            return s;
        }
    }
    @Test
    public User Select(String username){
        String sql="SELECT * FROM studentuser WHERE username=?";
        Object user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
        return (User) user;
    }
}

package Project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean Login(String username,String password){
        String sql="SELECT password FROM test WHERE username=?";
        try {
            String passwordresult=jdbcTemplate.queryForObject(sql,String.class,username);
            boolean s=password.equals(passwordresult);
            return s;
        }catch (Exception e){
            boolean s=false;
            return s;
        }
    }
}

package Project.dao;

import Project.pojo.User;
import com.sun.corba.se.spi.ior.ObjectKey;
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
    /*---------------判断账号是否可用-------------*/
    public boolean judge_use(String username){
        boolean temp=true;
        String sql="SELECT state FROM studentuser WHERE username=?";
        try {
            String state=jdbcTemplate.queryForObject(sql,String.class,username);
            if (state.equals("T")){
                temp=true;
            }else {
                temp=false;
            }
        }catch (Exception e){
            temp=false;
        }
        return temp;
    }
    public String Identify(String username){
        String sql="SELECT identify FROM studentuser WHERE username=?";
        String s=jdbcTemplate.queryForObject(sql,String.class,username);
        return s;
    }
    public User Select(String username){
        String sql="SELECT * FROM studentuser WHERE username=?";
        Object user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
        return (User) user;
    }
    public Integer Updatepassword(String username,String Opassword,String Npassword){
        int s;
        String sql="SELECT password FROM studentuser WHERE username=?";
        String t=jdbcTemplate.queryForObject(sql,String.class,username);
        if (Opassword.equals(t)) {
            String sql1="UPDATE studentuser SET password=? WHERE username=?";
            jdbcTemplate.update(sql1,Npassword,username);
            s=1;
        }else{
            s=0;
        }
        return s;
    }

}

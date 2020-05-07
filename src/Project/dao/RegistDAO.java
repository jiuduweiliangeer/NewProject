package Project.dao;

import Project.pojo.User;
import Project.service.Demo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegistDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional
    public void Regist(String username,String password,String email){
        String sql="INSERT INTO test VALUES(?,?,?)";
        int count=jdbcTemplate.update(sql,new Object[]{username,password,email});
        System.out.println(count);
    }
}

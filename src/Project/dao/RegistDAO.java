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
    @Autowired
    private LoginDAO loginDAO;
    @Transactional
    public void Regist(String username,String password,String email){
        String sql="INSERT INTO studentuser (username,password,email,identify,state) VALUES(?,?,?,?,?)";
        int count=jdbcTemplate.update(sql,new Object[]{username,password,email,"stu","T"});
        System.out.println(count);
    }
    public User UserMessage(String username,String major,Integer stuID,String gender,String stuclass,String name){
        String sql="UPDATE studentuser SET major=?,stuID=?,gender=?,stuclass=?,name=? WHERE username=?";
        jdbcTemplate.update(sql,major,stuID,gender,stuclass,name,username);
        User user=loginDAO.Select(username);
        return user;
    }
}

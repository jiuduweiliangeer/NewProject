package Project.dao;

import Project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserManageDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List findstu(){
        String identify="stu";
        String sql="SELECT * FROM studentuser WHERE identify=?";
        System.out.println("findstuDAO load...");
        List<User> users=jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setGender(resultSet.getString("gender"));
                user.setMajor(resultSet.getString("major"));
                user.setStuclass(resultSet.getString("stuclass"));
                user.setStuID(resultSet.getInt("stuID"));
                user.setTeaID(resultSet.getString("teaID"));
                return user;
            }
        }, identify);
        System.out.println(users);
        return users;
    }
}

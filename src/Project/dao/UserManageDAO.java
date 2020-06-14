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
    @Autowired
    private UserManageDAO userManageDAO;
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
                user.setName(resultSet.getString("name"));
                user.setGender(resultSet.getString("gender"));
                user.setMajor(resultSet.getString("major"));
                user.setStuclass(resultSet.getString("stuclass"));
                user.setStuID(resultSet.getInt("stuID"));
                user.setTeaID(resultSet.getString("teaID"));
                user.setState(resultSet.getString("state"));
                return user;
            }
        }, identify);
        System.out.println(users);
        return users;
    }
    /*-----------管理用户界面查询-------------*/
    public List selectfind(String state,String susername,String email){
        String identify="stu";
        int temp = 0;
        if (state!=""&&susername!=""&&email!=""){
            temp=123;
        }else if (state!=""&&susername!=""&&email==""){
            temp=12;
        }else if (state!=""&&email!=""&&susername==""){
            temp=13;
        }else if (susername!=""&&email!=""&&state==""){
            temp=23;
        }else if (state!=""&&susername==""&&email==""){
            temp=1;
        }else if (state==""&&susername!=""&&email==""){
            temp=2;
        }else if (state==""&&susername==""&&email!=""){
            temp=3;
        }else if (state==""&&susername==""&&email==""){
            temp=0;
        }
        List<User> users=null;
        String sql=null;
        switch (temp){
            case 123:
                sql="SELECT * FROM studentuser WHERE state=? AND username=? AND email=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                }, state,susername,email,identify);
                break;
            case 12:
                sql="SELECT * FROM studentuser WHERE state=? AND username=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                }, state,susername,identify);
                break;
            case 13:
                sql="SELECT * FROM studentuser WHERE state=? AND email=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                }, state,email,identify);
                break;
            case 23:
                sql="SELECT * FROM studentuser WHERE username=? AND email=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                },susername,email,identify);
                break;
            case 1:
                sql="SELECT * FROM studentuser WHERE state=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                }, state,identify);
                break;
            case 2:
                sql="SELECT * FROM studentuser WHERE username=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                },susername,identify);
                break;
            case 3:
                sql="SELECT * FROM studentuser WHERE email=? AND identify=?";
                users=jdbcTemplate.query(sql, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        user.setName(resultSet.getString("name"));
                        user.setGender(resultSet.getString("gender"));
                        user.setMajor(resultSet.getString("major"));
                        user.setStuclass(resultSet.getString("stuclass"));
                        user.setStuID(resultSet.getInt("stuID"));
                        user.setTeaID(resultSet.getString("teaID"));
                        user.setState(resultSet.getString("state"));
                        return user;
                    }
                },email,identify);
                break;
            case 0:
                users=userManageDAO.findstu();
                break;
        }
        System.out.println(users);
        return users;
    }
    /*-----------管理用户账户状态-------------*/
    public List openuser(String username){
        String state="T";
        String sql="UPDATE studentuser SET state=? WHERE username=?";
        jdbcTemplate.update(sql,state,username);
        List<User> users=userManageDAO.findstu();
        return users;
    }
    public List closeuser(String username){
        String state="F";
        String sql="UPDATE studentuser SET state=? WHERE username=?";
        jdbcTemplate.update(sql,state,username);
        List<User> users=userManageDAO.findstu();
        return users;
    }
    /*-----------后续学生选择座位时需要注意判定账户状态----------------*/
}

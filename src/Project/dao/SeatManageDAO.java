package Project.dao;

import Project.pojo.Seat;
import Project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.synth.SynthRootPaneUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SeatManageDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SeatManageDAO seatManageDAO;
    public List findset(){
        String sql="SELECT * FROM room_seat";
        List<Seat> seats=jdbcTemplate.query(sql, new RowMapper<Seat>() {
            @Override
            public Seat mapRow(ResultSet resultSet, int i) throws SQLException {
                Seat seat=new Seat();
                seat.setLocation(resultSet.getString("location"));
                seat.setState(resultSet.getString("state"));
                seat.setUseruse(resultSet.getString("useruse"));
                seat.setUsername(resultSet.getString("username"));
                return seat;
            }
        });
        System.out.println(seats);
        return seats;
    }
    /*---------------添加座位----------------*/
    public int addseat(String location) throws SQLException{
        String useruse="idle";
        String username="null";
        int temp;
        String sql="INSERT INTO room_seat (location,state) VALUES(?,?)";
        try{
            jdbcTemplate.update(sql,new Object[]{location,"T"});
            String sql1="UPDATE room_seat SET useruse=?,username=? WHERE location=?";
            jdbcTemplate.update(sql1,useruse,username,location);
            temp=1;
        }catch (Exception e){
            temp=0;
        }
        return temp;
    }
    /*--------------查询座位-----------------*/
    public List select_seat(String state,String location){
        String sql=null;
        int temp=0;
        if (state!=""&&location!=""){
            temp=12;
        }else if (state!=""&&location==""){
            temp=1;
        }else if (state==""&&location!=""){
            temp=2;
        }else if (state==""&&location==""){
            temp=0;
        }
        List<Seat> seats=null;
        switch (temp){
            case 12:
                sql="SELECT * FROM room_seat WHERE state=? AND location=?";
                seats=jdbcTemplate.query(sql, new RowMapper<Seat>() {
                    @Override
                    public Seat mapRow(ResultSet resultSet, int i) throws SQLException {
                        Seat seat=new Seat();
                        seat.setLocation(resultSet.getString("location"));
                        seat.setState(resultSet.getString("state"));
                        seat.setUseruse(resultSet.getString("useruse"));
                        seat.setUsername(resultSet.getString("username"));
                        return seat;
                    }
                },state,location);
                break;
            case 1:
                sql="SELECT * FROM room_seat WHERE state=?";
                seats=jdbcTemplate.query(sql, new RowMapper<Seat>() {
                    @Override
                    public Seat mapRow(ResultSet resultSet, int i) throws SQLException {
                        Seat seat=new Seat();
                        seat.setLocation(resultSet.getString("location"));
                        seat.setState(resultSet.getString("state"));
                        seat.setUseruse(resultSet.getString("useruse"));
                        seat.setUsername(resultSet.getString("username"));
                        return seat;
                    }
                },state);
                break;
            case 2:
                sql="SELECT * FROM room_seat WHERE location=?";
                seats=jdbcTemplate.query(sql, new RowMapper<Seat>() {
                    @Override
                    public Seat mapRow(ResultSet resultSet, int i) throws SQLException {
                        Seat seat=new Seat();
                        seat.setLocation(resultSet.getString("location"));
                        seat.setState(resultSet.getString("state"));
                        seat.setUseruse(resultSet.getString("useruse"));
                        seat.setUsername(resultSet.getString("username"));
                        return seat;
                    }
                },location);
                break;
            case 0:
                seats=seatManageDAO.findset();
                break;
        }
        return seats;
    }
    /*--------------维修座位----------------*/
    public List maintain_seat(String location){
        String sql="UPDATE room_seat SET state=? WHERE location=?";
        jdbcTemplate.update(sql,"T",location);
        List<Seat> seats=seatManageDAO.findset();
        return seats;
    }
    /*---------------删除座位---------------*/
    public List delete_seat(String location){
        String sql="DELETE FROM room_seat WHERE location=?";
        jdbcTemplate.update(sql,location);
        List<Seat> seats=seatManageDAO.findset();
        return seats;
    }
}

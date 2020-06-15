package Project.dao;

import Project.pojo.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Repository
public class SeatSelectDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SeatManageDAO seatManageDAO;
    @Autowired
    private SeatSelectDAO seatSelectDAO;
    /*-------------查询所有的座位--------------*/
    public List findselect_seat(){
        List<Seat> seats=seatManageDAO.findset();
        return seats;
    }
    /*------------学生报错修改座位状态------------*/
    @Transactional
    public List false_seat(String location,String username){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String sql="UPDATE room_seat SET state=?,useruse=? WHERE location=?";
        jdbcTemplate.update(sql,"F","false",location);
        String sql1="INSERT INTO history (username,location,date,operate) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql1,new Object[]{username,location,dateFormat.format(new Date()),"package false"});
        List<Seat> seats=seatSelectDAO.findselect_seat();
        return seats;
    }
    /*----------学生查询座位-----------------*/
    public List select_seat_stu(String useruse,String location){
        int temp=0;
        if (useruse!=""&&location!=""){
            temp=12;
        }else if(useruse!=""&&location==""){
            temp=1;
        }else if (useruse==""&&location==""){
            temp=0;
        }else if(useruse==""&&location!=""){
            temp=2;
        }
        String sql=null;
        List<Seat> seats=null;
        switch (temp){
            case 12:
                sql="SELECT * FROM room_seat WHERE useruse=? AND location=?";
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
                },useruse,location);
                break;
            case 1:
                sql="SELECT * FROM room_seat WHERE useruse=?";
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
                },useruse);
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
                seats=seatSelectDAO.findselect_seat();
                break;
        }
        return seats;
    }
}

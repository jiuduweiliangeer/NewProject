package Project.dao;

import Project.pojo.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SeatManageDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List findset(){
        String sql="SELECT * FROM room";
        List<Seat> seats=jdbcTemplate.query(sql, new RowMapper<Seat>() {
            @Override
            public Seat mapRow(ResultSet resultSet, int i) throws SQLException {
                Seat seat=new Seat();
                seat.setLocation(resultSet.getString("location"));
                seat.setState(resultSet.getString("state"));
                return seat;
            }
        });
        return seats;
    }
    /*---------------添加座位----------------*/
    public void addseat(String location){
        String sql="INSERT INTO room (location,state) VALUES(?,?)";
        jdbcTemplate.update(sql,new Object[]{location,"T"});
    }
}

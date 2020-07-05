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
        });;
        return seats;
    }
    /*------------学生报错修改座位状态------------*/
    @Transactional
    public List false_seat(String location,String username){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    /*-----------进入预约座位-------------------*/
    public int judge(String location,String username){
        int temp=0;
        String sql="SELECT useruse FROM room_seat WHERE location=?";
        String state=jdbcTemplate.queryForObject(sql,String.class,location);
        String u=null;
        String sql2="SELECT location FROM destine WHERE username=?";
        try{
            jdbcTemplate.queryForObject(sql2,String.class,username);
            u="1";
        }catch (Exception e){
            u=null;
        }
        if(state.equals("idle")&&u==null){
            temp=1;
        }else{
            temp=0;
        }
        return temp;
    }
    /*------------判断是*/
    /*------------插入预约时间等操作-------------------*/

    public void insert_time(String username,String location){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long currentTime = System.currentTimeMillis() + 30 * 60 * 1000;
        Date date1 = new Date(currentTime);
        String closetime=dateFormat.format(date1);
        String sql="INSERT INTO destine(username,location,opentime,closetime,state) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{username,location,dateFormat.format(new Date()),closetime,"\n" +
                "unconfirmed"});
        String sql1="INSERT INTO history(username,location,date,operate) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql1,new Object[]{username,location,dateFormat.format(new Date()),"destine"});
        String sql2="UPDATE room_seat SET useruse=?,username=? WHERE location=?";
        jdbcTemplate.update(sql2,"occupy",username,location);
    }
/*    *//*---------判断预约时间是否已经存在---------------*//*
    public boolean judgetime(String location,Date opendate,Date closedate){
        String sql="SELECT opentime FROM destine WHERE location=?";
        String sql1="SELECT closetime FROM destine WHERE location=?";
        Date opentime=jdbcTemplate.queryForObject(sql,Date.class,location);
        Date closetime=jdbcTemplate.queryForObject(sql1,Date.class,location);
        boolean temp=true;
        if(opendate.compareTo(closetime)>0){
            temp=true;
        }else if(opendate.compareTo(opentime)>0&&opendate.compareTo(closetime)<0){
            temp=false;
        }else if (opendate.compareTo(opentime)<0&&closedate.compareTo(opentime)<0){
            temp=true;
        }else if(closedate.compareTo(opentime)>0&&closedate.compareTo(closetime)<0){
            temp=false;
        }
        return false;
    }
    *//*---------------插入时间-----------------*//*
    public void insertTime(String username,String location,Date opentime,Date closetime){
        String sql="INSERT INTO destine(username,location,opentime,closetime) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{username,location,opentime,closetime});
    }*/
}

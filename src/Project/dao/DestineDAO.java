package Project.dao;

import Project.pojo.Dastine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Repository
public class DestineDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DestineDAO destineDAO;
    public Dastine select(String username){
        Dastine dastine=null;
        String sql="SELECT * FROM destine WHERE username=?";
        try {
            dastine=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Dastine.class),username);
        }catch (Exception e){
            dastine=null;
        }
        return dastine;
    }
    @Transactional
    public void destine_cancel(String username,String location){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql="DELETE FROM destine WHERE username=?";
        String sql2="UPDATE room_seat SET useruse=?,username=? WHERE location=?";
        String sql1="INSERT INTO history(username,location,date,operate) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,username);
        jdbcTemplate.update(sql2,"idle","null",location);
        jdbcTemplate.update(sql1,new Object[]{username,location,dateFormat.format(new Date()),"cancel destine"});
    }
    @Transactional
    public void destine_confirm(String username,String location){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql="UPDATE destine SET state=? WHERE username=?";
        String sql1="INSERT INTO history(username,location,date,operate) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,"confirmed",username);
        jdbcTemplate.update(sql1,new Object[]{username,location,dateFormat.format(new Date()),"confirm destine"});
    }
    @Transactional
    public void destine_end(String username,String location){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql="DELETE FROM destine WHERE username=?";
        String sql2="UPDATE room_seat SET useruse=?,username=? WHERE location=?";
        String sql1="INSERT INTO history(username,location,date,operate) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,username);
        jdbcTemplate.update(sql2,"idle","null",location);
        jdbcTemplate.update(sql1,new Object[]{username,location,dateFormat.format(new Date()),"delete destine"});
    }
    @Transactional
    public int judge_destine_time(String username){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int temp;
        try {
            String sql="SELECT * FROM destine WHERE username=?";
            Dastine dastine=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Dastine.class),username);
            String state=dastine.getState();
            if (state.equals("confirmed")){
                temp=1;
            }else{
                Date date=dastine.getClosetime();
                Date date1=new Date();
                if (date1.after(date)){
                    temp=0;
                }else {
                    temp=1;
                }
            }
        }catch (Exception e){
            temp=1;
        }
        return temp;
    }
    @Transactional
    public void destine_delete(String username){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql3="SELECT location FROM destine WHERE username=?";
        String location=jdbcTemplate.queryForObject(sql3,String.class,username);
        String sql="DELETE FROM destine WHERE username=?";
        String sql2="UPDATE room_seat SET useruse=?,username=? WHERE location=?";
        String sql1="INSERT INTO history(username,location,date,operate) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,username);
        jdbcTemplate.update(sql2,"idle","null",location);
        jdbcTemplate.update(sql1,new Object[]{username,location,dateFormat.format(new Date()),"default destine"});
    }
}

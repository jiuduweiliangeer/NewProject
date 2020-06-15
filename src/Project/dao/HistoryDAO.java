package Project.dao;

import Project.pojo.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class HistoryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*--------------进入对应用户的历史记录界面---------------*/
    public List findhistory(String username){
        String sql="SELECT * FROM history WHERE username=?";
        List<History> histories=jdbcTemplate.query(sql, new RowMapper<History>() {
            @Override
            public History mapRow(ResultSet resultSet, int i) throws SQLException {
                History history=new History();
                history.setUsername(resultSet.getString("username"));
                history.setLocation(resultSet.getString("location"));
                history.setDate(resultSet.getDate("date"));
                history.setOperate(resultSet.getString("operate"));
                return history;
            }
        },username);
        return histories;
    }
}

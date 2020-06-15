package Project.dao;

import Project.pojo.Publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class PublishDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List findpublish(){
        String sql="SELECT * FROM publish";
        List<Publish> publishes=jdbcTemplate.query(sql, new RowMapper<Publish>() {
            @Override
            public Publish mapRow(ResultSet resultSet, int i) throws SQLException {
                Publish publish=new Publish();
                publish.setUrlname(resultSet.getString("urlname"));
                publish.setPurl(resultSet.getString("purl"));
                return publish;
            }
        });
        return publishes;
    }
}

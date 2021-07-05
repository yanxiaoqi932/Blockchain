package Dao;
import Beans.Contribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ContributeDaoImpl implements ContributeDao{

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }




    @Override
    public int insert(Contribute c) {
        int user=c.getUser();
        int project=c.getProject();
        int num=c.getNum();
        String time=c.getTime();
        String user_name=c.getUser_name();
        String sql="insert into contribute values(null,?,?,?,?,?)";
        return jdbc.update(sql,user,project,num,time,user_name);
    }

    @Override
    public List<Contribute> get(int user) {
        List<Contribute>lists;
        String sql="select * from contribute where user=?";
        try{
            lists=jdbc.query(sql,new BeanPropertyRowMapper<>(Contribute.class),user);
        }catch (Exception e){
            return null;
        }
        return lists;
    }

    @Override
    public List<Contribute> get() {
        List<Contribute>lists;
        String sql="select * from contribute";
        try{
            lists=jdbc.query(sql,new BeanPropertyRowMapper<>(Contribute.class));
        }catch (Exception e){
            return null;
        }
        return lists;
    }

    @Override
    public List<Contribute> getByProject(int project) {
        List<Contribute>lists;
        String sql="select * from contribute where project=?";
        try{
            lists=jdbc.query(sql,new BeanPropertyRowMapper<>(Contribute.class),project);
        }catch (Exception e){
            return null;
        }
        return lists;
    }

    @Override
    public Integer count() {
        String sql="select count(*) from contribute";
        return jdbc.queryForObject(sql,Integer.class);
    }
}

package Dao;
import Beans.Projects;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProjectsImpl implements ProjectsDao{

    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insert(Projects s) {
        int user=s.getUser();
        String text=s.getText();
        int type=s.getType();
        String object=s.getObject();
        int num=s.getNum();
        String unit=s.getUnit();
        String user_name=s.getUser_name();
        String time=s.getTime();
        String sql="insert into projects values(null,?,?,?,?,?,?,?,?)";
        return jdbc.update(sql,user,text,type,object,num,unit,user_name,time);
    }

    @Override
    public List<Projects> get() {
        String sql="select * from projects";
        List<Projects>lists;
        try{
            lists= jdbc.query(sql,new BeanPropertyRowMapper<>(Projects.class));
        }catch (Exception e){
            return null;
        }
        return lists;
    }

    @Override
    public List<Projects> get(int user) {
        String sql="select * from projects where user=?";
        List<Projects>lists;
        try{
            lists= jdbc.query(sql,new BeanPropertyRowMapper<>(Projects.class),user);
        }catch (Exception e){
            return null;
        }
        return lists;
    }

    @Override
    public int updateNum(int id, int num) {
        String sql="update projects set num=num-? where id=?";
        return jdbc.update(sql,num,id);
    }

    @Override
    public Integer count() {
        String sql="select count(*) from projects";
        return jdbc.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Projects> getById(int project){
        String sql="select * from projects where id=?";
        List<Projects> p;
        try{
            p=jdbc.query(sql,new BeanPropertyRowMapper<>(Projects.class),project);
        }catch (Exception e){
            return null;
        }
        return p;
    }
}

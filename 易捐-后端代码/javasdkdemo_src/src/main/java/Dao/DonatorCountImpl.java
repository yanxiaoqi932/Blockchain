package Dao;

import Beans.Donator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DonatorCountImpl implements DonatorCountDao {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * @param type 0:个人捐赠者 1:单位捐赠
     */
    @Override
    public int insert(String name, int type) {
        String sql="insert into donatorcount select null,?,?,? from dual where not exists(select * from donatorcount where name=?)";
        return jdbc.update(sql,name,0,type,name);
    }

    @Override
    public List<Donator> getRank(int type) {
        String sql="select * from donatorcount where type=? order by contribute_count desc limit 10";
        List<Donator>lists;
        try{
            lists=jdbc.query(sql,new BeanPropertyRowMapper<>(Donator.class),type);
        }catch (Exception e){
            return null;
        }
        return lists;
    }

    @Override
    public int increase(String name) {
        String sql="update donatorcount set contribute_count=contribute_count+1 where name=?";
        return jdbc.update(sql,name);
    }
}

package Dao;
import Beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insert(User u) {
        String ID=u.getUser_ID();
        String password=u.getPassword();
        String sql="insert into user values(null,?,?)";
        return jdbc.update(sql,ID,password);
    }

    @Override
    public User getUserInfo(String  ID) {
        String sql="select * from user where user_ID=?";
        User u;
        try {
            u=jdbc.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),ID);
        }catch (Exception e){
            return null;
        }
        return u;
    }
}

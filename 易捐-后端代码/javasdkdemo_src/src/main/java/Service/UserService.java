package Service;
import Beans.User;
import Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public int checkUser(User u){
        User user=userDao.getUserInfo(u.getUser_ID());
        if(user==null){
            return -1;
        }else{
            int id=user.getId();
            if(u.getPassword().equals(user.getPassword())){
                return id;
            }else{
                return -1;
            }
        }
    }

    public boolean addUser(User u){
          return userDao.insert(u)!=-1;
    }

    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=context.getBean(UserService.class);
        User u=new User();
        u.setUser_ID("ian");
        u.setPassword("456234");
        System.out.println(userService.addUser(u));
    }
}

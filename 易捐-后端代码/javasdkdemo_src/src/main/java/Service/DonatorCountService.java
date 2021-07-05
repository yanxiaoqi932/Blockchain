package Service;

import Beans.Donator;
import Dao.DonatorCountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonatorCountService {

    private DonatorCountDao donatorCountDao;

    public DonatorCountDao getDonatorCountDao() {
        return donatorCountDao;
    }

    @Autowired
    public void setDonatorCountDao(DonatorCountDao donatorCountDao) {
        this.donatorCountDao = donatorCountDao;
    }

    public boolean insert(String name,int type){
        return donatorCountDao.insert(name,type)!=-1;
    }

    public List<Donator> getRank(int type){
        return donatorCountDao.getRank(type);
    }

    public boolean increase(String name){
        return donatorCountDao.increase(name)!=-1;
    }

}

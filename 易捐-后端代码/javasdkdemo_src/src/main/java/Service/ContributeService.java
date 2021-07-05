package Service;

import Beans.Contribute;
import Dao.ContributeDao;
import Dao.ProjectsDao;
import handler.FabricHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static handler.Main.LoopInvoke;

@Service
public class ContributeService {
    private ContributeDao contributeDao;
    private ProjectsDao projectsDao;


    public ProjectsDao getProjectsDao() {
        return projectsDao;
    }

    @Autowired
    public void setProjectsDao(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    public ContributeDao getContributeDao() {
        return contributeDao;
    }

    @Autowired
    public void setContributeDao(ContributeDao contributeDao) {
        this.contributeDao = contributeDao;
    }

    public List<Contribute> getContributes(){
        return contributeDao.get();
    }

    public boolean contribute(Contribute contribute) {
        FabricHelper helper = FabricHelper.getInstance();
//        helper.setConfigCtx("C:\\Users\\86153\\javasdkdemo_src\\config\\demo-channel-sdk-config.yaml");
//        try {
//            LoopInvoke(1,contribute.getUser_name(),Integer.toString(contribute.getNum()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return contributeDao.insert(contribute) != -1&&projectsDao.updateNum(contribute.getProject(),contribute.getNum())!=-1;
    }

    public List<Contribute>getContributeByProject(int project){
        return contributeDao.getByProject(project);
    }

    public List<Contribute> getContributeByUser(int user){
        return contributeDao.get(user);
    }

    public int count(){
        return contributeDao.count();
    }
}




package Service;

import Beans.Projects;
import Dao.ProjectsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    ProjectsDao projectsDao;

    public ProjectsDao getProjectsDao() {
        return projectsDao;
    }

    @Autowired
    public void setProjectsDao(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }

    public boolean addProject(Projects p){
        return projectsDao.insert(p)!=-1;
    }

    public List<Projects> getProjects(){
        return projectsDao.get();
    }

    public List<Projects> getProjects(int user){
        return projectsDao.get(user);
    }

    public int count(){
        return projectsDao.count();
    }

    public List<Projects> getById(int id){
        return projectsDao.getById(id);
    }
}

package Dao;

import Beans.Projects;

import java.util.List;

public interface ProjectsDao {
    int insert(Projects s);
    Integer count();
    List<Projects>get();
    List<Projects>get(int user);
    List<Projects> getById(int project);
    int updateNum(int id,int num);
}

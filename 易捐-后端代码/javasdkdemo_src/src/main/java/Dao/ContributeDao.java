package Dao;

import Beans.Contribute;

import java.util.List;

public interface ContributeDao {
    int insert(Contribute c);
    List<Contribute> get(int user);
    List<Contribute> get();
    Integer count();
    List<Contribute> getByProject(int project);
}

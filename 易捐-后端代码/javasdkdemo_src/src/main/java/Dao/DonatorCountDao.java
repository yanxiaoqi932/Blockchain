package Dao;

import Beans.Donator;

import java.util.List;

public interface DonatorCountDao {
    int insert(String name,int type);
    List<Donator> getRank(int type);
    int increase(String name);
}

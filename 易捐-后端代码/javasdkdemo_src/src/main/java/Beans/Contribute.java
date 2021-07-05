package Beans;

import com.alibaba.fastjson.annotation.JSONField;

public class Contribute {
    @JSONField(name = "id")
    private int id;
    @JSONField(name="user")
    private int user;
    @JSONField(name = "project")
    private int project;
    @JSONField(name="num")
    private int num;
    @JSONField(name="time")
    private String time;
    @JSONField(name="user_name")
    private String user_name;
    @JSONField(name = "object")
    private String object;
    @JSONField(name="projectProvider")
    private String projectProvider;
    @JSONField(name="unit")
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getObject() {
        return object;
    }

    public String getProjectProvider() {
        return projectProvider;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setProjectProvider(String projectProvider) {
        this.projectProvider = projectProvider;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public int getProject() {
        return project;
    }

    public int getNum() {
        return num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

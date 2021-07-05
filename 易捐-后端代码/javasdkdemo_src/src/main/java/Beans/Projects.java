package Beans;
import com.alibaba.fastjson.annotation.JSONField;


public class Projects {
    @JSONField(name = "id")
    private int id;

    @JSONField(name = "user")
    private int user;

    @JSONField(name="name")
    private String text;

    @JSONField(name = "type")
    private int type;

    @JSONField(name = "object")
    private String object;

    @JSONField(name = "num")
    private int num;

    @JSONField(name = "unit")
    private String unit;

    @JSONField(name = "user_name")
    private String user_name;

    @JSONField(name = "time")
    private String time;


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

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public String getObject() {
        return object;
    }

    public int getNum() {
        return num;
    }

    public String getUnit() {
        return unit;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}

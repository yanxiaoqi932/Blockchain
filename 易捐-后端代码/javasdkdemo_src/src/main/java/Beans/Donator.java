package Beans;

import com.alibaba.fastjson.annotation.JSONField;

public class Donator {
    @JSONField(name = "id")
    private int id;
    @JSONField(name="name")
    private String name;
    @JSONField(name="contribute_count")
    private int contribute_count;
    @JSONField(name="type")
    private int type;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getContribute_count() {
        return contribute_count;
    }

    public int getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContribute_count(int contribute_count) {
        this.contribute_count = contribute_count;
    }

    public void setType(int type) {
        this.type = type;
    }
}

package org.example;

import java.util.Date;

public class YoungestEldestWorker {
    private String name;
    private Date birthday;
    private String type;

    public YoungestEldestWorker(String name, Date birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorker" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", type='" + type;
    }
}

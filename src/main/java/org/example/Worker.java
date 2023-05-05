package org.example;


import java.sql.Date;

public class Worker  {
    private String name;
    private Date birthday;
    private  String level;
    private Integer salary;

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public Integer getSalary() {
        return salary;
    }

    public Worker(String name, Date birthday, String level, Integer salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }
}

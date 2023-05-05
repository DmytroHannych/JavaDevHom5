package org.example.DTO;


import java.sql.Date;

public class Project {
    private Integer client_id;
    private Date start_date;
    private Date finish_date;

    public Integer getClient_id() {
        return client_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public Project(Integer client_id, Date start_date, Date finish_date) {
        this.client_id = client_id;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    @Override
    public String toString() {
        return "Project" +
                "client_id=" + client_id +
                ", start_date=" + start_date +
                ", finish_date=" + finish_date;
    }
}

package org.example.DTO;

public class ProjectAndWorker {
    private Integer project_id;
    private Integer worker_id;

    public ProjectAndWorker(Integer project_id, Integer worker_id) {
        this.project_id = project_id;
        this.worker_id = worker_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public Integer getWorker_id() {
        return worker_id;
    }

    @Override
    public String toString() {
        return "Project_Worker" +
                "project_id=" + project_id +
                ", worker_id=" + worker_id;
    }
}

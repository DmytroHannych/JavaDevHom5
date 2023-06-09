package org.example;

import org.example.DTO.Project;
import org.example.DTO.ProjectAndWorker;
import org.example.DTO.Worker;
import org.example.Service.DatabasePopulateService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InputToTableData {
    static Database database = Database.getInstance();
    private static PreparedStatement prst;
    static Connection con = database.getConnection();
    DatabasePopulateService databasePopulateService = new DatabasePopulateService();

    public static void main(String[] args) throws SQLException {
        InputToTableData inputToTableData = new InputToTableData();
        inputToTableData.insertToTableWorkerDate();
        inputToTableData.insertToTableClient();
        inputToTableData.insertToTableProjectDate();
        inputToTableData.insertToTableProject_WorkerDate();
        prst.close();
        con.close();
    }

    public void insertToTableClient() throws SQLException {
        prst = con.prepareStatement("INSERT INTO client (name) VALUES (?)");
        String[] names = {"Igor", "Alex", "Bruno", "Fill", "Alex2"};
        for (String name : names) {
            prst.setString(1, name);
            prst.addBatch();
        }
        prst.executeBatch();
    }


    public void insertToTableWorkerDate() throws SQLException {
        List<Worker> workers = databasePopulateService.getWorkersDataFromFile();
        prst = con.prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?,?,?,?)");
        for (Worker worker: workers) {
            prst.setString(1, worker.getName());
            prst.setDate(2,worker.getBirthday());
            prst.setString(3, worker.getLevel());
            prst.setInt(4,worker.getSalary());
           prst.addBatch();
        }
         prst.executeBatch();
    }
    public void insertToTableProjectDate() throws SQLException {
        List<Project> projects = databasePopulateService.getProjectDataFromFile();
        prst = con.prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES (?,?,?)");
        for (Project project: projects) {
            prst.setInt(1, project.getClient_id());
            prst.setDate(2, project.getStart_date());
            prst.setDate(3, project.getFinish_date());
            prst.addBatch();
        }
        prst.executeBatch();
    }

    public void insertToTableProject_WorkerDate() throws SQLException {
        List<ProjectAndWorker> project_And_workers = databasePopulateService.getProjectWorkerDataFromFile();
        prst = con.prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES(?,?)");
        for (ProjectAndWorker project_And_worker : project_And_workers) {
            prst.setInt(1, project_And_worker.getProject_id());
            prst.setInt(2, project_And_worker.getWorker_id());
            prst.addBatch();
        }
        prst.executeBatch();
    }


}

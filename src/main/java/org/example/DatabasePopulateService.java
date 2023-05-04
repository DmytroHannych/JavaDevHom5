package org.example;

import org.h2.store.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale;

public class DatabasePopulateService {
    public static final String INSERT_DB = "sql/populate_db.sql";
    Database database = Database.getInstance();
    private PreparedStatement prst;
    Connection con =database.getConnection();

    public static void main(String[] args) throws SQLException {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
//        databasePopulateService.insertToTableWorker();
//        databasePopulateService.insertToTableClient();
        databasePopulateService.insertToTableProject();
        databasePopulateService.insertToTableProject_Worker();
    }
    public void insertToTableWorker() throws SQLException {
        prst = con.prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?,?,?,?)");
        String [] names = {"Petro","Ivan","Alex","Iryna","Maryna","Ander","Oleg","Olga","Yriy","Dmytro"};
       LocalDate[] birthdays = {LocalDate.parse("1997-01-07"), LocalDate.parse("1998-10-17"),
               LocalDate.parse("2000-01-12"), LocalDate.parse("1993-04-27"),
               LocalDate.parse("2003-11-11"), LocalDate.parse("2002-12-17"),
               LocalDate.parse("1996-05-05"), LocalDate.parse("1995-06-06"),
               LocalDate.parse("1998-02-25"), LocalDate.parse("1997-02-07")};
       String[] levels ={"Junior" ,"Trainee", "Trainee", "Middle", "Junior", "Senior", "Middle"," Junior", "Middle", "Senior"};
       Integer[] salares = {1200, 850, 800, 2800, 1000, 4800, 2400, 1100, 2500, 5100};
        for (String name:names) {
            prst.setString(1,name);
            prst.addBatch();
        }
        for (LocalDate birthday:birthdays) {
            prst.setString(2,birthday.toString());
            prst.addBatch();
        }
        for (String level:levels) {
            prst.setString(3,level);
            prst.addBatch();
        }
        for (Integer salary:salares) {
            prst.setInt(4,salary);
            prst.addBatch();
        }
        prst.executeBatch();
    }


    public void insertToTableClient() throws SQLException {
        prst = con.prepareStatement("INSERT INTO client (name) VALUES (?)");
        String[] names = {"Igor","Alex","Bruno","Fill","Alex2"};
        for (String name:names) {
            prst.setString(1,name);
            prst.addBatch();
        }
        prst.executeBatch();
    }

    public void insertToTableProject() throws SQLException {
        prst = con.prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES (?,?,?)");
        Integer[] clients_id = {1,2,3,4,5,1,5,3,4,5};
        Date[] start_dates = {Date.valueOf("2020-05-12"), Date.valueOf("2021-01-12"), Date.valueOf("2019-07-19"),
                Date.valueOf("2021-02-02"), Date.valueOf("2020-11-11"),
                Date.valueOf("2022-01-02"), Date.valueOf("2018-04-20"),
                Date.valueOf("2021-07-10"), Date.valueOf("2021-11-03"), Date.valueOf("2022-07-25")};
        Date[] finish_dates = {Date.valueOf("2021-05-05"), Date.valueOf("2021-12-05"),
                Date.valueOf("2022-04-05"), Date.valueOf("2022-01-05"), Date.valueOf("2020-12-30"),
                Date.valueOf("2022-07-15"), Date.valueOf("2019-01-01"), Date.valueOf("2022-01-13"),
                Date.valueOf("2022-02-07"), Date.valueOf("2019-04-04")};

        for (Integer client_id:clients_id) {
            prst.setInt(1,client_id);
            prst.addBatch();
        }
        for (Date start_date:start_dates) {
            prst.setDate(2, start_date);
            prst.addBatch();
        }
        for (Date finish_date:finish_dates) {
            prst.setDate(3, finish_date);
            prst.addBatch();
        }
        prst.executeBatch();
    }

    public void insertToTableProject_Worker() throws SQLException {
        prst = con.prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES (?,?)");
        Integer[] projects_id = {1,2,3,4,5,6,7,8,9,10};
        Integer[] workers_id ={1,4,8,9,2,5,7,3,10,6};
        for (Integer project_id:projects_id) {
            prst.setInt(1,project_id);
            prst.addBatch();
        }
        for (Integer worker_id:workers_id) {
            prst.setInt(2,worker_id);
            prst.addBatch();
        }
        prst.executeBatch();
    }
}

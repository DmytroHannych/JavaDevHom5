package org.example.Service;

import org.example.DTO.*;
import org.example.Database;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {
    private static final String Find_MAX_Proj_Client = "sql/find_max_projects_client.sql";
    private static final String Find_MAX_Salary = "sql/find_max_salary_worker.sql";
    private static final String Find_Long_Project = "sql/find_longest_project.sql";
    private static final String Find_Youngest = "sql/find_youngest_eldest_workers.sql";
    private static final String Print_Project_Price = "sql/print_project_prices.sql";
    Database database = Database.getInstance();
    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException, IOException {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(Find_MAX_Proj_Client)));
        PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String name = rs.getString(1);
            Integer projectCount = rs.getInt(2);
            maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
        }
        rs.close();
        preparedStatement.close();
        return maxProjectCountClients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException, IOException {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(Find_MAX_Salary)));
        PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String name = rs.getString(1);
            BigDecimal salary = rs.getBigDecimal(2);
            maxSalaryWorkers.add(new MaxSalaryWorker(name, salary));
        }
        rs.close();
        preparedStatement.close();
        return maxSalaryWorkers;
    }

    public List<YoungestEldestWorker> findYoundestEldestWorkers() throws SQLException, IOException {
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();
        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(Find_Youngest)));
        PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String name = rs.getString(1);
            Date birthday = rs.getDate(2);
            String type = rs.getString(3);
            youngestEldestWorkers.add(new YoungestEldestWorker(name, birthday, type));

        }
        rs.close();
        preparedStatement.close();
        return youngestEldestWorkers;
    }

    public  List<LongestProject> findLongestProgect() throws SQLException, IOException {
        List<LongestProject> longestProjects = new ArrayList<>();
        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(Find_Long_Project)));
        PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            String id = rs.getString(1);
            Integer mounth = rs.getInt(2);
            longestProjects.add(new LongestProject(id,mounth));

        }else{
            System.out.println("Result not found");
        }
        rs.close();
        preparedStatement.close();
        return longestProjects;
    }


    public List<ProgectCost> findProjectCost() throws SQLException, IOException {
        List<ProgectCost> progectCosts = new ArrayList<>();
        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(Print_Project_Price)));
        PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt(1);
            BigDecimal cost = rs.getBigDecimal(2);
            progectCosts.add(new ProgectCost(id,cost));

        }
        rs.close();
       preparedStatement.close();
        return progectCosts;
    }


    public void printList() throws SQLException, IOException {
        System.out.println(findMaxProjectsClient());
        System.out.println(findMaxSalaryWorker());
        System.out.println(findLongestProgect());
        System.out.println(findYoundestEldestWorkers());
        System.out.println(findProjectCost());

    }
}

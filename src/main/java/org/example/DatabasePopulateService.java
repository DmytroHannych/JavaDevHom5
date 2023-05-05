package org.example;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        databasePopulateService.getWorkersDataFromFile();
        databasePopulateService.getProjectDataFromFile();
        databasePopulateService.getProject_WorkerDataFromFile();
    }


    public List<Worker> getWorkersDataFromFile() {
        List<Worker> worker = new ArrayList<>();
        File file = new File("worker.txt");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] splitLine = line.split(",");
                    String name = splitLine[0];
                    Date birtnday = Date.valueOf(splitLine[1]);
                    String level = splitLine[2];
                    Integer salary = Integer.parseInt(splitLine[4]);
                    worker.add(new Worker(name, birtnday, level, salary));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return worker;
    }

    public List<Project> getProjectDataFromFile() {
        List<Project> project = new ArrayList<>();
        File file = new File("project.txt");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] splitLine = line.split(",");
                    Integer client_id = Integer.parseInt(splitLine[0]);
                    Date start_date = Date.valueOf(splitLine[1]);
                    Date finish_date = Date.valueOf(splitLine[2]);
                    project.add(new Project(client_id, start_date, finish_date));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return project;
    }

    public List<Project_Worker> getProject_WorkerDataFromFile() {
        List<Project_Worker> project_workers = new ArrayList<>();
        File file = new File("project_worker.txt");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] splitLine = line.split(",");
                    Integer project_id = Integer.parseInt(splitLine[0]);
                    Integer worker_id = Integer.parseInt(splitLine[1]);

                    project_workers.add(new Project_Worker(project_id, worker_id));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return project_workers;
    }

}


package org.example.Service;

import org.example.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;


public class DatabaseInitService {
    public static final String INIT_DB = "sql/init_db.sql";
    public static void main(String[] args) throws SQLException {

        Database database = Database.getInstance();
        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(INIT_DB)));
            database.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static final String INSERT_DB = "sql/populate_db.sql";
    public static void main(String[] args) throws SQLException {

        Database database = Database.getInstance();
        try {
            String sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(INSERT_DB)));
            database.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

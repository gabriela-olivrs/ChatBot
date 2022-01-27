package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySqlConection {

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "71184084");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}

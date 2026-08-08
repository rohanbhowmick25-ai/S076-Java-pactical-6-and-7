package json_java;

import java.sql.*;

public class sql_java {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "root";

        String query = "SELECT * FROM employees";

        try {
       Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("---------------------");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
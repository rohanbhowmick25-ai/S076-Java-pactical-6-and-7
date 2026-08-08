package json_java;

import java.sql.*;
import java.util.Scanner;

public class sql_java2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        String query = "SELECT * FROM employees WHERE id=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Age : " + rs.getInt("age"));
                System.out.println("Department : " + rs.getString("department"));
            } else {
                System.out.println("Record not found.");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
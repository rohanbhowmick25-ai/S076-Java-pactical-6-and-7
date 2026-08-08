package json_java;

import java.sql.*;
import java.util.Scanner;

public class sql_java3 {

    static String url = "jdbc:mysql://localhost:3306/test_db";
    static String user = "root";
    static String password = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Insert");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                insert();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }

    static void insert() {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO employees VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.print("ID: ");
            ps.setInt(1, sc.nextInt());

            sc.nextLine();

            System.out.print("Name: ");
            ps.setString(2, sc.nextLine());

            System.out.print("Age: ");
            ps.setInt(3, sc.nextInt());

            sc.nextLine();

            System.out.print("Department: ");
            ps.setString(4, sc.nextLine());

            int rows = ps.executeUpdate();

            System.out.println(rows + " Record Inserted.");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void update() {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE employees SET name=?, age=?, department=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("New Name: ");
            String name = sc.nextLine();

            System.out.print("New Age: ");
            int age = sc.nextInt();

            sc.nextLine();

            System.out.print("New Department: ");
            String dept = sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, dept);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            System.out.println(rows + " Record Updated.");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void delete() {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM employees WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();

            System.out.println(rows + " Record Deleted.");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
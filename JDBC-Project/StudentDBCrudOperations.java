package JDBC;

import java.sql.*;
import java.util.Scanner;

public class StudentDBCrudOperations {

    public static void main(String[] args) {

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try ( // Create connection
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/sjbc", "root", "root"); Scanner sc = new Scanner(System.in)) {
                int operation;
                
                do {
                    System.out.println("\n===== MENU =====");
                    System.out.println("1. Create");
                    System.out.println("2. Retrieve");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("5. Exit");
                    
                    System.out.print("Enter choice: ");
                    operation = sc.nextInt();
                    sc.nextLine();
                    
                    switch (operation) {
                        case 1 -> {
                            System.out.print("First Name: ");
                            String firstName = sc.nextLine();
                            
                            System.out.print("Last Name: ");
                            String lastName = sc.nextLine();
                            
                            System.out.print("Age: ");
                            int age = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.print("Grade: ");
                            String grade = sc.nextLine();
                            
                            String insertSql = "INSERT INTO Student (firstname, lastname, age, grade) VALUES (?, ?, ?, ?)";
                            
                            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                                ps.setString(1, firstName);
                                ps.setString(2, lastName);
                                ps.setInt(3, age);
                                ps.setString(4, grade);
                                
                                int rows = ps.executeUpdate();
                                System.out.println(rows > 0 ? "✅ Student added" : "❌ Failed");
                            }
                        }
                        case 2 -> {
                            String selectSql = "SELECT * FROM Student";
                            
                            try (Statement st = connection.createStatement();
                                    ResultSet rs = st.executeQuery(selectSql)) {
                                
                                while (rs.next()) {
                                    System.out.println(
                                            "ID: " + rs.getInt("student_id") +
                                                    ", Name: " + rs.getString("firstname") + " " + rs.getString("lastname") +
                                                    ", Age: " + rs.getInt("age") +
                                                    ", Grade: " + rs.getString("grade"));
                                }
                            }
                        }
                        case 3 -> {
                            System.out.print("Enter student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.println("1. Update Name");
                            System.out.println("2. Update Age");
                            System.out.println("3. Update Grade");
                            
                            System.out.print("Choice: ");
                            int choice = sc.nextInt();
                            sc.nextLine();
                            
                            String updateSql = "";
                            
                            switch (choice) {
                                case 1 -> {
                                    System.out.print("New First Name: ");
                                    String newF = sc.nextLine();
                                    
                                    System.out.print("New Last Name: ");
                                    String newL = sc.nextLine();
                                    
                                    updateSql = "UPDATE Student SET firstname=?, lastname=? WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setString(1, newF);
                                        ps.setString(2, newL);
                                        ps.setInt(3, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }
                                    
                                case 2 -> {
                                    System.out.print("New Age: ");
                                    int newAge = sc.nextInt();
                                    
                                    updateSql = "UPDATE Student SET age=? WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setInt(1, newAge);
                                        ps.setInt(2, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }
                                    
                                case 3 -> {
                                    sc.nextLine();
                                    System.out.print("New Grade: ");
                                    String newGrade = sc.nextLine();
                                    
                                    updateSql = "UPDATE Student SET grade=? WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setString(1, newGrade);
                                        ps.setInt(2, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }
                                    
                                default -> System.out.println("❌ Invalid choice");
                            }
                        }
                        case 4 -> {
                            System.out.print("Enter student ID: ");
                            int deleteId = sc.nextInt();
                            
                            String deleteSql = "DELETE FROM Student WHERE student_id=?";
                            
                            try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
                                ps.setInt(1, deleteId);
                                
                                System.out.println(ps.executeUpdate() > 0 ? "✅ Deleted" : "❌ Not Found");
                            }
                        }
                        
                        case 5 -> System.out.println("👋 Exiting...");
                        
                        default -> System.out.println("❌ Invalid option");
                    }
                    // ✅ CREATE
                    // ✅ READ
                    // ✅ UPDATE
                    // ✅ DELETE
                    
                } while (operation != 5);
                
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
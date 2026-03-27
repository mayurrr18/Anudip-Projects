package JDBC;

import java.sql.*;
import java.util.Scanner;

public class LibraryDBCrudOperations{

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
                    System.out.println("1. Add book");
                    System.out.println("2. View books");
                    System.out.println("3. Update book");
                    System.out.println("4. Delete book");
                    System.out.println("5. Exit");
                    
                    System.out.print("Enter choice: ");
                    operation = sc.nextInt();
                    sc.nextLine();
                    
                    switch (operation) {
                        case 1 -> {
                            System.out.print("Student Name: ");
                            String Sname = sc.nextLine();
                            
                            System.out.print("BOOK Name: ");
                            String Bname = sc.nextLine();
                            
                            System.out.print("Quantity ");
                            int Bquantity = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.print("Section: ");
                            String Ssection = sc.nextLine();
                            
                            String insertSql = "INSERT INTO Library(Sname, Bname, Bquantity, Ssection) VALUES (?, ?, ?, ?)";
                            
                            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                                ps.setString(1, Sname);
                                ps.setString(2, Bname);
                                ps.setInt(3, Bquantity);
                                ps.setString(4, Ssection);
                                
                                int rows = ps.executeUpdate();
                                System.out.println(rows > 0 ? "✅ Book added" : "❌ Failed");
                            }
                        }
                        case 2 -> {
                            String selectSql = "SELECT * FROM Library";
                            
                            try (Statement st = connection.createStatement();
                                    ResultSet rs = st.executeQuery(selectSql)) {
                                
                                while (rs.next()) {
                                    System.out.println(
                                            "ID: " + rs.getInt("student_id") +
                                                    ", Studentname: " + rs.getString("Sname") + 
                                                    ", bookname: " + rs.getString("Bname") +                                        
                                                    ", BookQuantity: " + rs.getInt("Bquantity")+
                                                   ",Section:"+ rs.getString("Ssection"));
                                }
                            }
                        }
                        case 3 -> {
                            System.out.print("Enter student ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.println("1. Update Name");
                            System.out.println("2. Update book");
                            System.out.println("3. Update Quantity");
                              System.out.println("4. Update Section");
                            
                            System.out.print("Choice: ");
                            int choice = sc.nextInt();
                            sc.nextLine();
                            
                            String updateSql = "";
                            
                            switch (choice) {
                                case 1 -> {
                                    System.out.print("New Name: ");
                                    String newF = sc.nextLine();                             
                                    
                                    updateSql = "UPDATE Library SET Sname WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setString(1, newF);
                                       
                                        ps.setInt(2, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }
                                    
                                case 2 -> {
                                    System.out.print("New Bookname: ");
                                    int newbook = sc.nextInt();
                                    
                                    updateSql = "UPDATE Library SET Bname=? WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setInt(1, newbook);
                                        ps.setInt(2, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }
                                    
                                case 3 -> {
                                    sc.nextLine();
                                    System.out.print("New Quantity: ");
                                    String newQuantity = sc.nextLine();
                                    
                                    updateSql = "UPDATE Library SET Bquantity=? WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setString(1, newQuantity);
                                        ps.setInt(2, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }
                             case 4 -> {
                                    sc.nextLine();
                                    System.out.print("New Section: ");
                                    String newsection = sc.nextLine();
                                    
                                    updateSql = "UPDATE Library SET Ssection=? WHERE student_id=?";
                                    try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
                                        ps.setString(1, newsection);
                                        ps.setInt(2, id);
                                        
                                        System.out.println(ps.executeUpdate() > 0 ? "✅ Updated" : "❌ Not Found");
                                    }
                            }


                                    
                                default -> System.out.println("❌ Invalid choice");
                            }
                        }
                        case 5 -> {
                            System.out.print("Enter student ID: ");
                            int deleteId = sc.nextInt();
                            
                            String deleteSql = "DELETE FROM Library WHERE student_id=?";
                            
                            try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
                                ps.setInt(1, deleteId);
                                
                                System.out.println(ps.executeUpdate() > 0 ? "✅ Deleted" : "❌ Not Found");
                            }
                        }
                        
                        case 6 -> System.out.println("👋 Exiting...");
                        
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
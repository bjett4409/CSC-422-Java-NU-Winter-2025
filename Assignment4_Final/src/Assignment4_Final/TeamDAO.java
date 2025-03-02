package Assignment4_Final;

import java.sql.*;

public class TeamDAO {
    public void addTeam(int teamNumber, String name, String city, String managerName) {
        // Check if the team already exists
        String checkSql = "SELECT COUNT(*) FROM Team WHERE TeamNumber = ?";
        String insertSql = "INSERT INTO Team (TeamNumber, Name, City, ManagerName) VALUES (?, ?, ?, ?)";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
    
            checkStmt.setInt(1, teamNumber);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
    
            if (count > 0) {
                System.out.println("Team already exists with TeamNumber: " + teamNumber);
                return;  // Stop insertion if duplicate found
            }
    
            // Insert new team
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, teamNumber);
                insertStmt.setString(2, name);
                insertStmt.setString(3, city);
                insertStmt.setString(4, managerName);
                insertStmt.executeUpdate();
                System.out.println("Team added successfully!");
            }
    
        } catch (SQLException e) {
            System.out.println("Error adding team: " + e.getMessage());
        }
    }
    
    public void editTeam(int teamNumber, String newName, String newCity, String newManager) {
        String sql = "UPDATE Team SET Name=?, City=?, ManagerName=? WHERE TeamNumber=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setString(2, newCity);
            stmt.setString(3, newManager);
            stmt.setInt(4, teamNumber);
            stmt.executeUpdate();
            System.out.println("Team updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating team: " + e.getMessage());
        }
    }  
    
    public void deleteTeam(int teamNumber) {
        String sql = "DELETE FROM Team WHERE TeamNumber=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, teamNumber);
            stmt.executeUpdate();
            System.out.println("Team deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting team: " + e.getMessage());
        }
    }

    public void getAllTeams() {
        String sql = "SELECT * FROM Team";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== List of Teams ===");
            System.out.printf("%-5s | %-20s | %-15s | %-20s%n", "ID", "Name", "City", "Manager");
            System.out.println("---------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d | %-20s | %-15s | %-20s%n",
                        rs.getInt("TeamNumber"), rs.getString("Name"),
                        rs.getString("City"), rs.getString("ManagerName"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching teams: " + e.getMessage());
        }
    }    
}
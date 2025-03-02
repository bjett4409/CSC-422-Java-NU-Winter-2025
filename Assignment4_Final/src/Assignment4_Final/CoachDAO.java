package Assignment4_Final;

import java.sql.*;

public class CoachDAO {
    public void addCoach(String name, String telephone, int teamNumber) {
        String sql = "INSERT INTO Coach (Name, TelephoneNumber, TeamNumber) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, telephone);
            stmt.setInt(3, teamNumber);
            stmt.executeUpdate();
            System.out.println("Coach added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding coach: " + e.getMessage());
        }
    }

    public void editCoach(int coachID, String newName, String newPhone, int newTeamNumber) {
        String sql = "UPDATE Coach SET Name=?, TelephoneNumber=?, TeamNumber=? WHERE CoachID=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setString(2, newPhone);
            stmt.setInt(3, newTeamNumber);
            stmt.setInt(4, coachID);
            stmt.executeUpdate();
            System.out.println("Coach updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating coach: " + e.getMessage());
        }
    } 

    public void deleteCoach(int coachID) {
        String sql = "DELETE FROM Coach WHERE CoachID=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, coachID);
            stmt.executeUpdate();
            System.out.println("Coach deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting coach: " + e.getMessage());
        }
    }    

    public void getAllCoaches() {
        String sql = "SELECT * FROM Coach";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== List of Coaches ===");
            System.out.printf("%-5s | %-25s | %-15s | %-5s%n", "ID", "Name", "Phone", "Team");
            System.out.println("-----------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d | %-25s | %-15s | %-5d%n",
                        rs.getInt("CoachID"), rs.getString("Name"),
                        rs.getString("TelephoneNumber"), rs.getInt("TeamNumber"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching coaches: " + e.getMessage());
        }
    }    
}
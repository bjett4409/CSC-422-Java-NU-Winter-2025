package Assignment4_Final;

import java.sql.*;

public class PlayerDAO {
    public void addPlayer(int leagueNumber, String name, int age) {
        String sql = "INSERT INTO Player (LeagueWideNumber, Name, Age) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, leagueNumber);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            System.out.println("Player added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding player: " + e.getMessage());
        }
    }

    public void editPlayer(int playerID, String newName, int newAge) {
        String sql = "UPDATE Player SET Name=?, Age=? WHERE PlayerID=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, playerID);
            stmt.executeUpdate();
            System.out.println("Player updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating player: " + e.getMessage());
        }
    }
    
    public void deletePlayer(int playerID) {
        String sql = "DELETE FROM Player WHERE PlayerID=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playerID);
            stmt.executeUpdate();
            System.out.println("Player deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting player: " + e.getMessage());
        }
    }   

    public void getAllPlayers() {
        String sql = "SELECT * FROM Player";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n=== List of Players ===");
            System.out.printf("%-5s | %-25s | %-5s%n", "ID", "Name", "Age");
            System.out.println("-----------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%-5d | %-25s | %-5d%n",
                        rs.getInt("PlayerID"), rs.getString("Name"), rs.getInt("Age"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error fetching players: " + e.getMessage());
        }
    }    
}
package Assignment4_Final;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeamDAO teamDAO = new TeamDAO();
        PlayerDAO playerDAO = new PlayerDAO();
        CoachDAO coachDAO = new CoachDAO();

        while (true) {
            System.out.println("\n=== League Management System ===");
            System.out.println("1. Add Team");
            System.out.println("2. View Teams");
            System.out.println("3. Edit Team");
            System.out.println("4. Delete Team");
            System.out.println("5. Add Player");
            System.out.println("6. View Players");
            System.out.println("7. Edit Player");
            System.out.println("8. Delete Player");
            System.out.println("9. Add Coach");
            System.out.println("10. View Coaches");
            System.out.println("11. Edit Coach");
            System.out.println("12. Delete Coach");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Team Number: ");
                    int teamNum = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Team Name: ");
                    String teamName = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Manager Name: ");
                    String manager = scanner.nextLine();
                    teamDAO.addTeam(teamNum, teamName, city, manager);
                    break;

                case 2:
                    teamDAO.getAllTeams();
                    break;

                case 3:
                    System.out.print("Enter Team Number to Edit: ");
                    int editTeamNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = scanner.nextLine();
                    System.out.print("Enter New Manager: ");
                    String newManager = scanner.nextLine();
                    teamDAO.editTeam(editTeamNum, newName, newCity, newManager);
                    break;

                case 4:
                    System.out.print("Enter Team Number to Delete: ");
                    int delTeamNum = scanner.nextInt();
                    teamDAO.deleteTeam(delTeamNum);
                    break;

                case 5:
                    System.out.print("Enter League Number: ");
                    int leagueNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Player Name: ");
                    String playerName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    playerDAO.addPlayer(leagueNum, playerName, age);
                    break;

                case 6:
                    playerDAO.getAllPlayers();
                    break;

                case 7:
                    System.out.print("Enter Player ID to Edit: ");
                    int editPlayerID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newPlayerName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    playerDAO.editPlayer(editPlayerID, newPlayerName, newAge);
                    break;

                case 8:
                    System.out.print("Enter Player ID to Delete: ");
                    int delPlayerID = scanner.nextInt();
                    playerDAO.deletePlayer(delPlayerID);
                    break;

                case 9:
                    System.out.print("Enter Coach Name: ");
                    String coachName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Team Number: ");
                    int coachTeam = scanner.nextInt();
                    coachDAO.addCoach(coachName, phone, coachTeam);
                    break;

                case 10:  // View Coaches
                    coachDAO.getAllCoaches();
                    break;

                case 11:  // Edit Coach
                    System.out.print("Enter Coach ID to Edit: ");
                    int editCoachID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newCoachName = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter New Team Number: ");
                    int newCoachTeam = scanner.nextInt();
                    coachDAO.editCoach(editCoachID, newCoachName, newPhone, newCoachTeam);
                    break;

                case 12:  // Delete Coach
                    System.out.print("Enter Coach ID to Delete: ");
                    int delCoachID = scanner.nextInt();
                    coachDAO.deleteCoach(delCoachID);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please choose a valid menu item.");
            }
        }
    }
}

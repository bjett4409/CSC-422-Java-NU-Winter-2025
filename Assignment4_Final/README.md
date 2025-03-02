# README

## Connecting VS Code to the MySQL Database

### 1. Setting Up VS Code for SQL Database Connection

#### Step 1: Install Required Extensions

1. Open VS Code.
2. Navigate to Extensions (`Ctrl + Shift + X`).
3. Search for **SQL Server (mssql)** and install it.
4. If you use **MySQL**, search for "MySQL" and install an appropriate extension like **"MySQL Shell"** or **"MySQL Database"**.

#### Step 2: Install MySQL or SQL Server (If Not Installed)

- If you don’t have **MySQL** installed, download it from the [MySQL Official Site](https://dev.mysql.com/downloads/).
- For **SQL Server**, download [SQL Server Management Studio (SSMS)](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15) from Microsoft's website.

#### Step 3: Configure Database Connection in VS Code

1. Open **Command Palette** (`Ctrl + Shift + P`).
2. Select **MS SQL: Connect**.
3. Choose **MySQL** or **SQL Server**.
4. Enter the database connection details from `DatabaseConnection.java`:
   - **Server**: `127.0.0.1`
   - **Database Name**: `TennisLeague`
   - **Username**: `root`
   - **Password**: `1234$@!qazxswWSXZAQ`
5. Click **Connect**.

#### Step 4: Run SQL Queries in VS Code

1. Open a new SQL file (**File → New File → Select SQL**).
2. Write queries to interact with the database.
3. Click **Run** or use shortcut `Ctrl + Shift + E`.

---

### 2. Database Management: Available Operations

#### **Teams Management**

- **Add a Team**: `addTeam(int teamNumber, String name, String city, String managerName)`
- **View All Teams**: `getAllTeams()`
- **Edit a Team**: `editTeam(int teamNumber, String newName, String newCity, String newManager)`
- **Delete a Team**: `deleteTeam(int teamNumber)`

#### **Players Management**

- **Add a Player**: `addPlayer(int leagueNumber, String name, int age)`
- **View All Players**: `getAllPlayers()`
- **Edit a Player**: `editPlayer(int playerID, String newName, int newAge)`
- **Delete a Player**: `deletePlayer(int playerID)`

#### **Coaches Management**

- **Add a Coach**: `addCoach(String name, String telephone, int teamNumber)`
- **View All Coaches**: `getAllCoaches()`
- **Edit a Coach**: `editCoach(int coachID, String newName, String newPhone, int newTeamNumber)`
- **Delete a Coach**: `deleteCoach(int coachID)`

---

### 3. Running Java Program with Database

1. Open **VS Code Terminal** (`Ctrl + \``).

2. Navigate to the project folder:

   ```sh
   cd path/to/project
   ```

3. Compile the Java files:

   ```sh
   javac -cp ".;mysql-connector-j-9.1.0.jar" *.java
   ```

4. Run the program:

   ```sh
   java -cp ".;mysql-connector-j-9.1.0.jar" Main
   ```

5. Follow the on-screen menu to interact with the database.

---

### Notes

- Ensure **MySQL server** is running before attempting to connect.
- Use correct **username and password** for database access.
- Modify **JDBC connection string** in `DatabaseConnection.java` if using a different database setup.

---

This guide provides step-by-step instructions to set up, manage, and interact with the Tennis League database using **VS Code** and **Java**.

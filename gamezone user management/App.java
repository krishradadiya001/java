import java.sql.*;
import java.util.*;



 class GameZone {
	private static Connection con;

	public static void main(String[] args) throws Exception  {
	
			
			String dbUrl = "jdbc:mysql://localhost:3306/gamezone";
			String dbUser = "root";
			String dbPass = "";
			String drivername = "com.mysql.cj.jdbc.Driver";
			Class.forName(drivername);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);

			if (con != null) {
				System.out.println("Connection success");
				Scanner sc = new Scanner(System.in);

				while (true) {
					System.out.println("\n=== WELCOME TO GAMEZONE MANAGEMENT SYSTEM ===");
					System.out.println("1. Game Management");
					System.out.println("2. User Management");
					System.out.println("3. Booking System");
					System.out.println("4. Payment Processing");
					System.out.println("5. addleaderbordentry");
					System.out.println("6. generatereport");
					System.out.println("7. Exit");
					System.out.print("Enter your choice: ");
					int choice = sc.nextInt();

					switch (choice) {
					case 1:
						handleGameManagement();
						break;
					case 2:
						handleUserManagement();
						break;
					case 3:
						handleBookingSystem();
						break;
					case 4:
						handlePaymentProcessing();
						break;
						case 5:
							leaderboard lb = new leaderboard();
							lb.addleaderboard();
						break;
					case 6: reportgenerator rg = new reportgenerator();
							rg.generateReport();
							break;
					case 7:
						System.out.println("Thank you for using GameZone Management System");
						sc.close();
						if (con != null) {
							con.close();
						}
						return;
					default:
						System.out.println("Invalid choice. Please enter again.");
					}
				}
			} else {
				System.out.println("Connection fail");
			}
	
	}

	 static void handleGameManagement() {
		Scanner sc = new Scanner(System.in);
		GameManagement gameManagement = new GameManagement(con);

		while (true) {
			System.out.println("\n=== GAME MANAGEMENT ===");

			System.out.println("1. View Games");
			System.out.println("2. search games");
            System.out.println("3. Update Game Availability");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			
			case 1:gameManagement.viewGames();
            break;
				
			case 2:linkedlist ll = new linkedlist();
			gameManagement.searchgame();
			System.out.println("enter game to search");
			String gname = sc.next();
			ll.searchllgame(gname);
			if(ll.searchllgame(gname))
			{
				System.out.println("game is in gamezone");
			}
			else
			{
				System.out.println("game is not in gamezone");
			}
			break;
			case 3: linkedlist ll1 = new linkedlist();
			sc.nextLine(); // Consume newline
			gameManagement.searchgame();
            System.out.print("Enter name of game to update availability: ");
            String gameName = sc.next();
			ll1.searchllgame(gameName);
			if(ll1.searchllgame(gameName))
			{
				System.out.print("Enter new availability (1 if available, 0 if not available): ");
            int newAvailability = sc.nextInt();
            gameManagement.updateGameAvailability(gameName, newAvailability);
			}
			else
			{
				System.out.println("game is not in gamezone");
			}
            break;	
			case 4:
				return;
			default:
				System.out.println("Invalid choice. Please enter again.");
			}
		}
	}

	private static void handleUserManagement() {
		Scanner sc = new Scanner(System.in);
		UserManagement userManagement = new UserManagement(con);

		while (true) {
			System.out.println("\n=== USER MANAGEMENT ===");
			System.out.println("1. Register User");
			System.out.println("2. to check user exiest or not");
			System.out.println("3. view user list");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine(); // Consume newline

				System.out.print("Enter name of user: ");
					 String nameofuser = sc.next();
		
				System.out.println("\n Your User ID Rules Are");
				userManagement.userIDRules();
				System.out.print("\n" + nameofuser + " Please Enter Your User ID For Game Zone: ");
				String userID = sc.next();
				while(true){
					boolean flag = userManagement.isValidUserID(userID);
					if(!flag){
						System.out.print("Sorry It is not valid User ID!! Please enter valid User ID: ");
						userID = sc.nextLine();
					}
					else {
						System.out.println("Ok!! " + nameofuser + " Your User ID is Set");
						break;
					}
				}

				System.out.println("\n" + nameofuser + " Your Password Rules Are");
				userManagement.passwordRules();
		
				System.out.print("Enter password: ");
				String password = sc.nextLine();
				while(true){
					boolean flag = userManagement.isValidPassword(password);
					if(!flag){
						System.out.println("Sorry It is not valid password!! Please enter valid password");
						password = sc.nextLine();
					}
					else {
						System.out.println("Ok!! " + nameofuser  + " Your password is Set\n");
						break;
					}
				}
		
				
				userManagement.registerUser(nameofuser, userID, password);
				break;
			case 2:	linkedlist ll = new linkedlist();

			 System.out.print("Enter username: ");
			String userName = sc.next();
			userManagement.searchuser();
			ll.searchlluser(userName);
			if(ll.searchlluser(userName))
			{
				System.out.println("user exist in gamezone");
			}
			else
			{
				System.out.println("user not exist in gamezone");
			}
				break;
			case 3:userManagement.viewuserlist();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice. Please enter again.");
			}
		}
	}

	private static void handleBookingSystem() {
		Scanner sc = new Scanner(System.in);
		GameManagement gameManagement = new GameManagement(con);
		BookingSystem bookingSystem = new BookingSystem(con);
		UserManagement 	UserManagement = new UserManagement(con);
		while (true) {
			System.out.println("\n=== BOOKING SYSTEM ===");
			System.out.println("1. Book Game Session");
			System.out.println("2. View Bookings");
			System.out.println("3. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:linkedlist ll = new linkedlist();
			gameManagement.viewGames();
				sc.nextLine(); // Consume newline
				System.out.print("Enter username: ");
				String userName = sc.nextLine();
				UserManagement.searchuser();
				ll.searchlluser(userName);
				if(ll.searchlluser(userName))
				{
				System.out.print("Enter game name: ");
				String gameName = sc.nextLine();
				gameManagement.searchgame();
				ll.searchllgame(gameName);
			if(ll.searchllgame(gameName))
			{
				System.out.print("Enter booking date (YYYY-MM-DD): ");
				String date = sc.nextLine();
				System.out.print("Enter game duration (in minutes): ");
				int duration = sc.nextInt();
				bookingSystem.bookGameSession(userName, gameName, date, duration);
			}
			else
			{
				System.out.println("game is not in gamezone");
			}
		}
		else
		{
			System.out.println("user not exist in gamezone");
		}
			break;
				
			case 2:
				bookingSystem.viewBookings();
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid choice. Please enter again.");
			}
		}
	}

	private static void handlePaymentProcessing() {
		Scanner sc = new Scanner(System.in);
		PaymentProcessing paymentProcessing = new PaymentProcessing(con);
		GameManagement gameManagement = new GameManagement(con);
		UserManagement userManagement = new UserManagement(con);
		while (true) {
			System.out.println("\n=== PAYMENT PROCESSING ===");
			System.out.println("1. Process Payment");
			System.out.println("2. View Payments");
			System.out.println("3. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:linkedlist ll = new linkedlist();
			gameManagement.viewGames();
				sc.nextLine(); // Consume newline
				System.out.print("Enter username: ");
				String userName = sc.nextLine();
				userManagement.searchuser();
			ll.searchlluser(userName);
			if(ll.searchlluser(userName))
			{
				System.out.print("Enter amount to pay: ");
				double amount = sc.nextDouble();
				sc.nextLine(); // Consume newline
				System.out.print("Enter payment method:(card/cash) ");
				String paymentMethod = sc.nextLine();
				if(paymentMethod.equalsIgnoreCase("card"))
				{
					int k=0;
					while(k!=3)
					{
						k++;
					System.out.println("enter cardno");
					String cardno = sc.next();
					if(cardno.length()==16)
					{
						k=3;
				paymentProcessing.processPayment(userName, amount, paymentMethod);
					}
					else
					{
						System.out.println("plese enter valid cardno");
					}
				}
				}
				else
				{
					System.out.println("pay ment via cash");
					paymentProcessing.processPayment(userName, amount, paymentMethod);
				}
			}
			else
			{
				System.out.println("user not exist in gamezone");
			}
				
				break;
				
			case 2:
				paymentProcessing.viewPayments();
				break;
			case 3:
				return;
			default:
				System.out.println("Invalid choice. Please enter again.");
			}
		}
	}
    static class GameManagement {
		private Connection con;

		public GameManagement(Connection con) {
			this.con = con;
		}
		public void updateGameAvailability(String gameName, int newAvailability) {
			try {
				String query = "UPDATE games SET availability = ? WHERE game_name = ?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, newAvailability);
				pstmt.setString(2, gameName);
				int updatedRows = pstmt.executeUpdate();
				if (updatedRows > 0) {
					System.out.println("Availability updated for game: " + gameName);
				} else {
					System.out.println("Game not found: " + gameName);
				}
			} catch (SQLException e) {
				System.out.println("Error updating availability: " + e.getMessage());
			}
		}

		

		public void viewGames() {
			try {
				Statement stmt = con.createStatement();
				String query = "SELECT * FROM games";
				ResultSet rs = stmt.executeQuery(query);
				System.out.println("\n=== LIST OF GAMES ===");
				System.out.printf("%-20s %-20s %-15s %-10s\n", "Game Name", "Game Type", "Availability", "Price");
				System.out.println("===============================================================");
				while (rs.next()) {
					String name = rs.getString("game_name");
					String type = rs.getString("game_type");
					int availability = rs.getInt("availability");
					double price = rs.getDouble("price");
					System.out.printf("%-20s %-20s %-15d %-10.2f\n", name, type, availability, price);
				}
			} catch (SQLException e) {
				System.out.println("Error viewing games: " + e.getMessage());
			}
		}
		public void searchgame()
		{
			linkedlist ll = new linkedlist();
			try{
				Statement st = con.createStatement();
				String q = "select game_name from games";
				ResultSet rs =st.executeQuery(q);
				while(rs.next())
				{
					ll.insertgame(rs.getString(1));
				}
			
				
			}
			catch (Exception e) {
				System.out.println("Error viewing searchgamegames: " + e.getMessage());
			}
			
		}
	}

static	class UserManagement {
		private Connection con;

		public UserManagement(Connection con) {
			this.con = con;
		}

		static void usernamerules()
		{
			System.out.println("-->1. username should include upper and lowercase letters.");
			System.out.println("-->2. username should not include a number.");
			System.out.println("-->3. username should not include a special character.");
		}
		static void userIDRules(){

			System.out.println("-->1. The email address must contain exactly one @ symbol.");
			System.out.println("-->2. The @ symbol must not be the first or last character in the email address.");
			System.out.println("-->3. The email address must contain at least one .(DOT) symbol.");
			System.out.println("-->4. The .(DOT) symbol must not be the first or last character in the email address.");
			System.out.println("-->5. The .(DOT) symbol must be after the @ symbol.");
			System.out.println("-->6. The email address must not contain any spaces.");
	
		}
		static boolean isValidUserID(String userID){

			boolean flag = false;
			if (userID != null && userID.length() > 0) {
				int atCount = 0;
				int dotCount = 0;
				int atIndex = 0;
				int dotIndex = 0;
				for (int i = 0; i < userID.length(); i++) {
					char c = userID.charAt(i);
					if (c == '@') {
						atCount++;
						atIndex = i+1;
					} else if (c == '.') {
						dotCount++;
						dotIndex = i;
					}
				}
	
				for(int i=0;i<userID.length();i++){
					char c = userID.charAt(i);
					if(c >=65 && c <= 90){
						return false;
					}
	
				}
	
				if(userID.startsWith("@") || userID.endsWith("@") || userID.startsWith(".") || userID.endsWith(".") || userID.contains(" ")){
	
					return false;
	
				}
	
				if (atCount == 1 && dotCount == 1 && userID.indexOf("@") < userID.indexOf(".") && userID.endsWith("com") && userID.substring(atIndex , dotIndex).equals("gmail")) {
	
					flag = true;
				}
			}
			return flag;
	
		}
		static void passwordRules(){

			System.out.println("-->1. Length: Password should be at least 8 characters long. ");
			System.out.println("-->2. Password should include a mix of upper and lowercase letters.");
			System.out.println("-->3. Password should include a number.");
			System.out.println("-->4. Password should include a special character.");
	
		}
		static boolean isValidPassword(String password) {
			if (password.length() < 8 ) {
				return false;
			}
	
			boolean hasSpecialChar = false;
			boolean hasUppercase = false;
			boolean hasLowercase = false;
			boolean hasDigit = false;
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (Character.isUpperCase(c)) {
					hasUppercase = true;
				} else if (Character.isLowerCase(c)) {
					hasLowercase = true;
				} else if (Character.isDigit(c)) {
					hasDigit = true;
				}
				else if (password.contains("!") || password.contains("@") || password.contains("#") || password.contains("$") || password.contains("%") || password.contains("&") || password.contains("*") || password.contains("?") || password.contains("(") || password.contains(")")){
					hasSpecialChar = true;
				}
			}
			return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
		}
		public void registerUser(String name, String userID, String password) {
			try {
				String query = "INSERT INTO users (user_name, userID, password) VALUES (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setString(2, userID);
				pstmt.setString(3, password);
				pstmt.executeUpdate();
				System.out.println("User registered successfully.");
			} catch (SQLException e) {
				System.out.println("Error registering user: " + e.getMessage());
			}
		}
		public void viewuserlist() {
			try {
				Statement st = con.createStatement();
				String q = "select * from users";
				ResultSet rs =st.executeQuery(q);

				System.out.print("user_name"+"\t\t");
				System.out.print("userId"+"\t\t");
				System.out.print("password");
				System.out.println();
				while(rs.next())
				{
					System.out.print(rs.getString(1)+"\t\t");
					System.out.print(rs.getString(2)+"\t\t");
					System.out.print(rs.getString(3));
					System.out.println();
				}
			} catch (SQLException e) {
				System.out.println("Error viewing user: " + e.getMessage());
			}
		}
		public void searchuser()
		{
			linkedlist ll = new linkedlist();
			try{
				Statement st = con.createStatement();
				String q = "select user_name from users";
				ResultSet rs =st.executeQuery(q);
				while(rs.next())
				{
					ll.insertuser(rs.getString(1));
				}
			
				
			}
			catch (Exception e) {
				System.out.println("Error viewing searchgamegames: " + e.getMessage());
			}
			
		}
		
	}

	static class BookingSystem {
		private Connection con;

		public BookingSystem(Connection con) {
			this.con = con;
		}

		public void bookGameSession(String userName, String gameName, String date, int duration) {
			try {
				Statement stmt = con.createStatement();
				String query = "INSERT INTO bookings (user_name, game_name, booking_date, duration) VALUES (?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, userName);
				
				pstmt.setString(2, gameName);
				pstmt.setString(3, date);
				pstmt.setInt(4, duration);
				pstmt.executeUpdate();
				System.out.println("Game session booked successfully.");
			} catch (Exception e) {
				System.out.println("Error booking game session: " + e.getMessage());
			}
		}

		public void viewBookings() {
			try {
				Statement stmt = con.createStatement();
				String query = "SELECT * FROM bookings";
				ResultSet rs = stmt.executeQuery(query);
				System.out.println("\n=== LIST OF BOOKINGS ===");
				System.out.printf("%-20s %-20s %-15s %-10s\n", "User Name", "Game Name", "Booking Date", "Duration");
				System.out.println("===============================================================");
				while (rs.next()) {
					String userName = rs.getString("user_name");
					String gameName = rs.getString("game_name");
					String bookingDate = rs.getString("booking_date");
					int duration = rs.getInt("duration");
					System.out.printf("%-20s %-20s %-15s %-10d\n", userName, gameName, bookingDate, duration);
				}
			} catch (SQLException e) {
				System.out.println("Error viewing bookings: " + e.getMessage());
			}
		}
	}

static	class PaymentProcessing {
		private Connection con;

		public PaymentProcessing(Connection con) {
			this.con = con;
		}

		public void processPayment(String userName, double amount, String paymentMethod) {
			try {
				String query = "INSERT INTO payments (user_name, amount, payment_method) VALUES (?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, userName);
				pstmt.setDouble(2, amount);
				pstmt.setString(3, paymentMethod);
				pstmt.executeUpdate();
				System.out.println("Payment processed successfully.");
			} catch (SQLException e) {
				System.out.println("Error processing payment: " + e.getMessage());
			}
		}

		public void viewPayments() {
			try {
				Statement stmt = con.createStatement();
				String query = "SELECT * FROM payments";
				ResultSet rs = stmt.executeQuery(query);
				System.out.println("\n=== LIST OF PAYMENTS ===");
				System.out.printf("%-20s %-15s %-20s\n", "User Name", "Amount", "Payment Method");
				System.out.println("===============================================================");
				while (rs.next()) {
					String userName = rs.getString("user_name");
					double amount = rs.getDouble("amount");
					String paymentMethod = rs.getString("payment_method");
					System.out.printf("%-20s %-15.2f %-20s\n", userName, amount, paymentMethod);
				}
			} catch (SQLException e) {
				System.out.println("Error viewing payments: " + e.getMessage());
			}
		}
	}
	static class leaderboard
	{
		Scanner sc = new Scanner(System.in);
		GameManagement gameManagement = new GameManagement(con);
		UserManagement userManagement = new UserManagement(con);
		linkedlist ll = new linkedlist();
		public void addleaderboard() throws SQLException
		{
			System.out.println("enter username to add leaderboard");
			String usern = sc.next();
			userManagement.searchuser();
			ll.searchlluser(usern);
			if(ll.searchlluser(usern))
			{ 
				System.out.println("enter game name");
				String gamen = sc.next();
				gameManagement.searchgame();
				ll.searchllgame(gamen);
			if(ll.searchllgame(gamen))
			{
				System.out.println("enter score");
				int score = sc.nextInt();
				String q = "insert into leaderboard (user_name,game_name,score) values (?,?,?)";
				PreparedStatement pst = con.prepareStatement(q);
				pst.setString(1,usern);
				pst.setString(2,gamen);
				pst.setInt(3, score);
				pst.executeUpdate();

				
			}
			else{
				System.out.println("game not exist");
			}
		}
			else
			{
				System.out.println("user not exist");
			}
		
	}
}

	static class reportgenerator
	{
		UserManagement userManagement = new UserManagement(con);
		linkedlist ll = new linkedlist();
		Scanner sc = new Scanner(System.in);
		public void generateReport() throws SQLException {
			// Example report: Game popularity
			System.out.println("ENTER NAME OF USER TO GENERATE REPORT");
			String uname = sc.next();
			userManagement.searchuser();
			ll.searchlluser(uname);
			if(ll.searchlluser(uname))
			{
				String query = "select leaderboard.user_name,leaderboard.game_name,leaderboard.score from leaderboard inner join bookings on leaderboard.user_name = bookings.user_name where bookings.user_name=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, uname);
			ResultSet rs =pst.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" you book "+rs.getString(2)+" game in gamezone and your score is"+rs.getString(3));
				}
			}
			else
			{
				System.out.println("user not exist in gamezone");
			}
			
	}
}
}

class linkedlist
{
		
	class node
	{
public static linkedlist.node first;
String data;
node next;

node(String data)
{
	this.data =data;
	node next =null;
}
	}
	static node first = null;
	void insertgame(String data)
	{
		node n = new node(data);
		if(first == null)
		{
			first=n;
		}
		else{
			node temp = first;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	public boolean searchllgame(String gname) {
        node temp = first;
        while (temp != null) {
            if (temp.data.equals(gname)) {
                return true; // node found
            }
            temp = temp.next;
        }
        return false; // node not found
    }	
	void insertuser(String data)
	{
		node n = new node(data);
		if(first == null)
		{
			first=n;
		}
		else{
			node temp = first;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	public boolean searchlluser(String usernme) {
        node temp = first;
        while (temp != null) {
            if (temp.data.equals(usernme)) {
                return true; //when  node found
            }
            temp = temp.next;
        }
        return false; // when node not found
    }	
}



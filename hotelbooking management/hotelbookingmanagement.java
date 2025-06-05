import java.util.*;
class Room 
{
    String guestName;
     boolean isBooked;
      double roomPrice;

     Room(double roomPrice) 
	{
        this.guestName = "Available";
        this.isBooked = false;
        this.roomPrice = roomPrice;
    }

    String getGuestName()
	{
        return guestName;
    }

    void setGuestName(String guestName)
	{
        this.guestName = guestName;
    }

    boolean isBooked() 
	{
        return isBooked;
    }

    double getroomPrice()
	{
        return roomPrice;
    }

     double getPrice() 
	{
        return isBooked? roomPrice:+roomPrice;
    }

     void bookRoom(String guestName) 
	{
        this.guestName = guestName;
        this.isBooked = true;
    }

     void releaseRoom() 
	{
        this.guestName = "Available";
        this.isBooked = false;
    }
}

 class HotelBookingManagement 
{
	
    public static void main(String[] args)
	{
		 int roomPrice = 2000;
        Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Hotel Booking Management System!");	
        int numRooms=0;   
            while(true)
            {
                System.out.println("Enter the number of rooms in the hotel: ");
                numRooms = sc.nextInt();
                if(numRooms>0)
                    break;
                else
                    System.out.println("Rooms should not zero");                
            }
				
            System.out.println("  room price for booking a room: $"+roomPrice);
             

            Room [] rooms = new Room[numRooms];

            for (int i = 0; i < numRooms; i++)
			{
                rooms[i] = new Room(roomPrice);
            }

            while (true) 
			{
				userMenu();
                
                    int choice = sc.nextInt();
                    sc.nextLine(); 

                    switch (choice)
					{
						case 1:
							bookRoom(rooms);
							break;
						case 2:
							viewBookings(rooms);
							break;
						case 3:
							checkAvailability(rooms);
							break;
						
						case 4:
							checkout(rooms);
							break;
						case 5:
							viewRoomDetails(rooms);
							break;
						
						case 6:
							System.out.println("Thank you for using the system. Have a great day!");
							System.exit(0);
						default:
							System.out.println("Invalid choice. Please try again.");
					}
			}
	}
	

         
    

    static void userMenu()
	{
        System.out.println("Hotel Booking Management System");
        System.out.println("press 1. Book a Room");
        System.out.println("press 2. View Bookings");
        System.out.println("press 3. Check Room Availability");
        System.out.println("press 4. CheckOut Room");
        System.out.println("press 5. View Room Details");
        System.out.println("press 6. Exit");
        System.out.println("Enter your choice: ");
    }

    static void bookRoom(Room[] rooms )
	{
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Booking a Room");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        if(rooms.length==1)
        System.out.println("Enter room no: ");
        else
        System.out.println("Enter the room number (1-" + rooms.length + "): ");
        int roomNumber = sc.nextInt();

        if (roomNumber < 1 || roomNumber > rooms.length) 
		{
            System.out.println("Invalid room number. Please choose a valid room.");
            return;
        }

        Room selectedRoom = rooms[roomNumber - 1];

        if (!selectedRoom.isBooked()) 
		{
            selectedRoom.bookRoom(name);
            System.out.println("Room " + roomNumber + " booked successfully for " + name + ".");
            System.out.println("Total Price: $" + selectedRoom.getPrice());
        } else 
		{
            System.out.println("Sorry, the room is already booked. Please choose another room.");
        }
    }

    static void viewBookings(Room[] rooms)
	{
		
		
        System.out.println("Viewing Room Bookings:");
        for (int i = 0; i < rooms.length; i++)
		{
            if (rooms[i].isBooked()) 
			{
                System.out.println("Room " + (i + 1) + ": " + rooms[i].getGuestName() +
                        " (Price: $" + rooms[i].getPrice() + ")");
						
            }
		}
		System.out.println("no other booking at this time");
    }

     static void checkAvailability(Room[] rooms) {
        System.out.println("Checking Room Availability:");
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i].isBooked()) {
                System.out.println("Room " + (i + 1) + " is available (Price: $" + rooms[i].getPrice() + ")");
            }
        }
		System.out.println("no other room avalible at this time");
    }

     

     static void checkout(Room[] rooms) {
		 Scanner sc = new Scanner(System.in);
        System.out.println("checkout");
        if(rooms.length==1)
        System.out.println("Enter room no to  checkout:");
        else
        System.out.println("Enter the room number (1-" + rooms.length + ") to checkout: ");
        int roomNumber = sc.nextInt();

        if (roomNumber < 1 || roomNumber > rooms.length) {
            System.out.println("Invalid room number. Please choose a valid room.");
            return;
        }

        Room selectedRoom = rooms[roomNumber - 1];

        if (selectedRoom.isBooked()) {
            System.out.println("Room " + roomNumber + " is currently booked for " + selectedRoom.getGuestName() +
                    " (Price: $" + selectedRoom.getPrice() + ").");

            System.out.print("Do you want to release this room? (yes/no): ");
            String releaseChoice = sc.next().toLowerCase();

            if (releaseChoice.equals("yes")) {
                selectedRoom.releaseRoom();
                System.out.println("Room " + roomNumber + " released successfully.");
            } else {
                System.out.println("Booking modification canceled.");
            }
        } else {
            System.out.println("Room " + roomNumber + " is not currently booked.");
        }
    }

    static void viewRoomDetails(Room[] rooms) 
	{
        System.out.println("Viewing Room Details:");
        for (int i = 0; i < rooms.length; i++)
		{
            System.out.println("Room " + (i + 1) + ": " + (rooms[i].isBooked() ? "Booked" : "Available") +" (Price: $" + rooms[i].getPrice() + ")");
        }
    }

    
	
}
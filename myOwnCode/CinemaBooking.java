import java.util.Scanner;


    static Scanner scanner = new Scanner(System.in);
    static char[][] seats = new char[5][5];

    public static void main(String[] args) {

        initializeSeats();

        boolean isRunning = true;

        System.out.println("=== Cinema Box Office ===");

        while (isRunning) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Show seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Exit");
            System.out.print("> ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                // 2. Use switch for the menu
                switch (choice) {
                    case 1:
                        printSeats();
                        break;
                    case 2:
                        buyTicket();
                        break;
                    case 3:
                        isRunning = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } else {
                System.out.println("Please enter a number!");
                scanner.next();
            }
        }
    }

    // Method 1: Fills the array with '-'
    public static void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = '-';
            }
        }
    }

    // Method 2: Prints the array (hall map) nicely to the console
    public static void printSeats() {
        System.out.println("\n  1 2 3 4 5  (Seats)");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + " "); // Print row number
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }

    // Method 3: Booking logic (checks boundaries and availability)
    public static void buyTicket() {
        System.out.print("Enter row number (1-5): ");
        int row = scanner.nextInt() - 1;

        System.out.print("Enter seat number (1-5): ");
        int col = scanner.nextInt() - 1;


        if (row < 0 || row >= 5 || col < 0 || col >= 5) {
            System.out.println("Error: Invalid seat coordinates!");
            return; // Exit the method immediately
        }


        if (seats[row][col] == 'X') {
            System.out.println("Error: This seat is already taken!");
        } else {
            seats[row][col] = 'X'; // Mark as taken
            System.out.println("Success! Ticket booked.");
        }
    }

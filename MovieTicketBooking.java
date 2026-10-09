package hashset;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store booked seat numbers
        Set<Integer> bookedSeats = new HashSet<>();

        int totalSeats = 20;
        int choice;

        while (true) {

            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. Book a Seat");
            System.out.println("2. Cancel a Booking");
            System.out.println("3. Display Booked Seats");
            System.out.println("4. Display Available Seats");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter seat number (1-20): ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid seat number!");
                        sc.next();
                        break;
                    }

                    int bookSeat = sc.nextInt();

                    if (bookSeat < 1 || bookSeat > totalSeats) {
                        System.out.println("Invalid seat number!");
                    } else if (bookedSeats.add(bookSeat)) {
                        System.out.println(
                            "Seat " + bookSeat + " booked successfully!"
                        );
                    } else {
                        System.out.println(
                            "Seat " + bookSeat + " is already booked!"
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter seat number to cancel: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid seat number!");
                        sc.next();
                        break;
                    }

                    int cancelSeat = sc.nextInt();

                    if (cancelSeat < 1 || cancelSeat > totalSeats) {
                        System.out.println("Invalid seat number!");
                    } else if (bookedSeats.remove(cancelSeat)) {
                        System.out.println(
                            "Booking for seat " + cancelSeat
                            + " cancelled successfully!"
                        );
                    } else {
                        System.out.println(
                            "Seat " + cancelSeat + " is not booked!"
                        );
                    }
                    break;

                case 3:
                    if (bookedSeats.isEmpty()) {
                        System.out.println("No seats are booked.");
                    } else {
                        System.out.println("Booked seats: "
                                           + bookedSeats);
                    }
                    break;

                case 4:
                    System.out.println("Total seats: " + totalSeats);
                    System.out.println(
                        "Booked seats: " + bookedSeats.size()
                    );
                    System.out.println(
                        "Available seats: "
                        + (totalSeats - bookedSeats.size())
                    );
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice! Please select 1 to 5."
                    );
            }
        }
    }
}

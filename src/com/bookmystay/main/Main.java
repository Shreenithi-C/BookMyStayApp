package com.bookmystay.main;

import com.bookmystay.inventory.Inventory;
import com.bookmystay.search.SearchService;
import com.bookmystay.bookingqueue.BookingQueue;
import com.bookmystay.bookingqueue.Reservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // UC1: Inventory setup
        Inventory inventory = new Inventory();
        inventory.addRoomType("Single", 5, 2000.0);
        inventory.addRoomType("Double", 3, 3500.0);
        inventory.addRoomType("Suite", 2, 6000.0);

        // UC2: Search
        SearchService searchService = new SearchService(
                inventory.getRoomCounts(),
                inventory.getRoomPrices()
        );

        // UC3: Booking Queue
        BookingQueue bookingQueue = new BookingQueue();

        int choice;
        do {
            System.out.println("\n=== Booking Menu ===");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Add Booking Request");
            System.out.println("3. View Pending Requests");
            System.out.println("4. Process Next Request");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> searchService.displayAvailableRooms();
                case 2 -> {
                    System.out.print("Enter guest name: ");
                    String guest = sc.nextLine();
                    System.out.print("Enter room type: ");
                    String roomType = sc.nextLine();
                    Reservation reservation = new Reservation(guest, roomType);
                    bookingQueue.addRequest(reservation);
                }
                case 3 -> bookingQueue.displayQueue();
                case 4 -> bookingQueue.processNext();
                case 5 -> System.out.println("Exiting booking system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

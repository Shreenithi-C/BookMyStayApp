package com.bookmystay.main;

/*
 * @author developer
 * @version 4.0
 */

import com.bookmystay.inventory.Inventory;
import com.bookmystay.search.SearchService;
import com.bookmystay.bookingqueue.BookingQueue;
import com.bookmystay.bookingqueue.Reservation;
import com.bookmystay.booking.BookingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // UC1: Inventory setup
        Inventory inventory = new Inventory();
        inventory.addRoomType("Single", 2, 2000.0);
        inventory.addRoomType("Double", 2, 3500.0);
        inventory.addRoomType("Suite", 1, 6000.0);

        // UC2: Search
        SearchService searchService = new SearchService(
                inventory.getRoomCounts(),
                inventory.getRoomPrices()
        );

        // UC3: Booking Queue
        BookingQueue bookingQueue = new BookingQueue();

        // UC4: Booking Service
        BookingService bookingService = new BookingService(inventory);

        int choice;
        do {
            System.out.println("\n=== Booking Menu ===");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Add Booking Request");
            System.out.println("3. View Pending Requests");
            System.out.println("4. Process Next Request & Confirm Booking");
            System.out.println("5. View Room Allocations");
            System.out.println("6. Exit");
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
                case 4 -> {
                    Reservation next = bookingQueue.processNext();
                    if (next != null) {
                        bookingService.confirmBooking(next);
                    }
                }
                case 5 -> bookingService.displayAllocations();
                case 6 -> System.out.println("Exiting booking system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}

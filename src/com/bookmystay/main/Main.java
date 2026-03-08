package com.bookmystay.main;

/*
 * @author developer
 * @version 6.0
 */

import com.bookmystay.inventory.Inventory;
import com.bookmystay.search.SearchService;
import com.bookmystay.bookingqueue.BookingQueue;
import com.bookmystay.bookingqueue.Reservation;
import com.bookmystay.booking.BookingService;
import com.bookmystay.services.Service;
import com.bookmystay.services.ServiceManager;
import com.bookmystay.history.BookingHistory;

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

        // UC5: Service Manager
        ServiceManager serviceManager = new ServiceManager();

        // UC6: Booking History
        BookingHistory bookingHistory = new BookingHistory();

        int choice;
        do {
            System.out.println("\n=== Booking Menu ===");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Add Booking Request");
            System.out.println("3. View Pending Requests");
            System.out.println("4. Process Next Request & Confirm Booking");
            System.out.println("5. View Room Allocations");
            System.out.println("6. Add Service to Reservation");
            System.out.println("7. View Services for Reservation");
            System.out.println("8. View Booking History");
            System.out.println("9. Generate Booking Report");
            System.out.println("10. Exit");
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
                        boolean confirmed = bookingService.confirmBooking(next);
                        if (confirmed) {
                            bookingHistory.addReservation(next);
                        }
                    }
                }
                case 5 -> bookingService.displayAllocations();
                case 6 -> {
                    System.out.print("Enter reservation ID (e.g., Single-1): ");
                    String resId = sc.nextLine();
                    System.out.print("Enter service name: ");
                    String serviceName = sc.nextLine();
                    System.out.print("Enter service cost: ");
                    double cost = sc.nextDouble();
                    sc.nextLine();
                    serviceManager.addService(resId, new Service(serviceName, cost));
                }
                case 7 -> {
                    System.out.print("Enter reservation ID: ");
                    String resId = sc.nextLine();
                    serviceManager.displayServices(resId);
                    System.out.println("Total additional cost: ₹" + serviceManager.calculateCost(resId));
                }
                case 8 -> bookingHistory.displayHistory();
                case 9 -> bookingHistory.generateReport();
                case 10 -> System.out.println("Exiting booking system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 10);

        sc.close();
    }
}

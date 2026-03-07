package com.bookmystay.main;

import com.bookmystay.inventory.Inventory;
import com.bookmystay.search.SearchService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // UC1: Inventory setup by Admin
        Inventory inventory = new Inventory();
        System.out.println("=== Hotel Admin: Setup Inventory ===");
        System.out.print("Enter number of room types to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter room type: ");
            String type = sc.nextLine();
            System.out.print("Enter count: ");
            int count = sc.nextInt();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline
            inventory.addRoomType(type, count, price);
        }

        // UC2: Guest searches
        SearchService searchService = new SearchService(
                inventory.getRoomCounts(),
                inventory.getRoomPrices()
        );

        System.out.println("\n=== Guest: Search Rooms ===");
        searchService.displayAvailableRooms();

        System.out.print("\nEnter room type to check availability: ");
        String searchType = sc.nextLine();
        if (searchService.isAvailable(searchType)) {
            System.out.println(searchType + " is available @ ₹" + searchService.getPrice(searchType));
        } else {
            System.out.println(searchType + " is not available.");
        }

        sc.close();
    }
}

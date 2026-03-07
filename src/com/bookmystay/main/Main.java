package com.bookmystay.main;

import com.bookmystay.inventory.Inventory;

public class Main {
    public static void main(String[] args) {
        // Initialize inventory
        Inventory inventory = new Inventory();

        // Add room types
        inventory.addRoomType("Single", 5, 2000.0);
        inventory.addRoomType("Double", 3, 3500.0);
        inventory.addRoomType("Suite", 2, 6000.0);

        // Display inventory
        inventory.displayInventory();

        // Update counts and prices
        inventory.updateRoomCount("Single", 4);
        inventory.updateRoomPrice("Suite", 6500.0);

        // Display updated inventory
        System.out.println("\nAfter updates:");
        inventory.displayInventory();

        // Check availability and price
        System.out.println("\nAvailable Single rooms: " + inventory.getAvailableCount("Single"));
        System.out.println("Price of Suite: ₹" + inventory.getPrice("Suite"));
    }
}

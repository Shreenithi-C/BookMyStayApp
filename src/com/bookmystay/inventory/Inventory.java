package com.bookmystay.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> roomCounts = new HashMap<>();
    private Map<String, Double> roomPrices = new HashMap<>();

    // Add a new room type
    public void addRoomType(String type, int count, double price) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
    }

    // Update room count dynamically
    public void updateRoomCount(String type, int count) {
        if (roomCounts.containsKey(type)) {
            roomCounts.put(type, count);
        } else {
            System.out.println("Room type not found: " + type);
        }
    }

    // Update room price dynamically
    public void updateRoomPrice(String type, double price) {
        if (roomPrices.containsKey(type)) {
            roomPrices.put(type, price);
        } else {
            System.out.println("Room type not found: " + type);
        }
    }

    // Get availability count
    public int getAvailableCount(String type) {
        return roomCounts.getOrDefault(type, 0);
    }

    // Get price per night
    public double getPrice(String type) {
        return roomPrices.getOrDefault(type, 0.0);
    }

    // Display current inventory
    public void displayInventory() {
        System.out.println("=== Room Inventory ===");
        for (String type : roomCounts.keySet()) {
            System.out.println(type + " → " + roomCounts.get(type) + " rooms @ ₹" + roomPrices.get(type));
        }
    }
}

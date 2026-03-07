package com.bookmystay.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> roomCounts = new HashMap<>();
    private Map<String, Double> roomPrices = new HashMap<>();

    public void addRoomType(String type, int count, double price) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
    }

    public void updateRoomCount(String type, int count) {
        if (roomCounts.containsKey(type)) {
            roomCounts.put(type, count);
        } else {
            System.out.println("Room type not found: " + type);
        }
    }

    public void updateRoomPrice(String type, double price) {
        if (roomPrices.containsKey(type)) {
            roomPrices.put(type, price);
        } else {
            System.out.println("Room type not found: " + type);
        }
    }

    public int getAvailableCount(String type) {
        return roomCounts.getOrDefault(type, 0);
    }

    public double getPrice(String type) {
        return roomPrices.getOrDefault(type, 0.0);
    }

    public void displayInventory() {
        System.out.println("=== Room Inventory ===");
        for (String type : roomCounts.keySet()) {
            System.out.println(type + " → " + roomCounts.get(type) + " rooms @ ₹" + roomPrices.get(type));
        }
    }

    // Expose maps for SearchService (read-only usage)
    public Map<String, Integer> getRoomCounts() {
        return roomCounts;
    }

    public Map<String, Double> getRoomPrices() {
        return roomPrices;
    }
}

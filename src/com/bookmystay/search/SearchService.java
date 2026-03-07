package com.bookmystay.search;

import java.util.Map;

public class SearchService {
    private Map<String, Integer> roomCounts;
    private Map<String, Double> roomPrices;

    // Constructor takes references from Inventory
    public SearchService(Map<String, Integer> roomCounts, Map<String, Double> roomPrices) {
        this.roomCounts = roomCounts;
        this.roomPrices = roomPrices;
    }

    // Display available rooms with pricing
    public void displayAvailableRooms() {
        System.out.println("=== Available Rooms ===");
        for (String type : roomCounts.keySet()) {
            int count = roomCounts.getOrDefault(type, 0);
            double price = roomPrices.getOrDefault(type, 0.0);

            if (count > 0) {
                System.out.println(type + " → " + count + " rooms @ ₹" + price + " per night");
            }
        }
    }

    // Check if a room type is available
    public boolean isAvailable(String type) {
        return roomCounts.getOrDefault(type, 0) > 0;
    }

    // Defensive check for pricing
    public double getPrice(String type) {
        if (!roomPrices.containsKey(type)) {
            throw new IllegalArgumentException("Room type not found: " + type);
        }
        return roomPrices.get(type);
    }
}

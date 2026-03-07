package com.bookmystay.booking;

import com.bookmystay.bookingqueue.Reservation;
import com.bookmystay.inventory.Inventory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookingService {
    private Inventory inventory;
    private Set<String> bookedRoomIds = new HashSet<>();
    private Map<String, Set<String>> roomAllocations = new HashMap<>();

    public BookingService(Inventory inventory) {
        this.inventory = inventory;
    }

    // Confirm booking by assigning unique room ID
    public boolean confirmBooking(Reservation reservation) {
        String roomType = reservation.getRoomType();

        // Check availability
        if (inventory.getAvailableCount(roomType) <= 0) {
            System.out.println("Booking failed: No " + roomType + " rooms available.");
            return false;
        }

        // Generate unique room ID (e.g., Single-1, Suite-2)
        String roomId = roomType + "-" + (bookedRoomIds.size() + 1);

        // Ensure uniqueness
        if (bookedRoomIds.contains(roomId)) {
            System.out.println("Booking failed: Room ID already allocated.");
            return false;
        }

        // Allocate room
        bookedRoomIds.add(roomId);
        roomAllocations.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);

        // Update inventory count
        inventory.updateRoomCount(roomType, inventory.getAvailableCount(roomType) - 1);

        System.out.println("Booking confirmed for " + reservation.getGuestName() +
                " → Room ID: " + roomId);
        return true;
    }

    // Display all allocations
    public void displayAllocations() {
        System.out.println("=== Current Room Allocations ===");
        for (String type : roomAllocations.keySet()) {
            System.out.println(type + " → " + roomAllocations.get(type));
        }
    }
}

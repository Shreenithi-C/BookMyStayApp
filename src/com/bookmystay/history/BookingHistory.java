package com.bookmystay.history;

import com.bookmystay.bookingqueue.Reservation;

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
    private List<Reservation> confirmedReservations = new ArrayList<>();

    // Add confirmed reservation to history
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
        System.out.println("Added to booking history: " + reservation);
    }

    // Cancel reservation (remove from history)
    public void cancelReservation(Reservation reservation) {
        if (confirmedReservations.remove(reservation)) {
            System.out.println("Cancelled reservation: " + reservation);
        } else {
            System.out.println("Reservation not found in history.");
        }
    }

    // Display all confirmed reservations
    public void displayHistory() {
        System.out.println("=== Booking History ===");
        if (confirmedReservations.isEmpty()) {
            System.out.println("No confirmed reservations.");
        } else {
            for (Reservation r : confirmedReservations) {
                System.out.println(r);
            }
        }
    }

    // Generate simple report (count of reservations)
    public void generateReport() {
        System.out.println("=== Booking Report ===");
        System.out.println("Total confirmed reservations: " + confirmedReservations.size());
    }
}

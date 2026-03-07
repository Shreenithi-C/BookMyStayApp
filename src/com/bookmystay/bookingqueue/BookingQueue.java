package com.bookmystay.bookingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BookingQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Booking request added: " + reservation);
    }

    // Process next request (FIFO)
    public Reservation processNext() {
        Reservation next = queue.poll();
        if (next != null) {
            System.out.println("Processing booking request: " + next);
        } else {
            System.out.println("No booking requests in queue.");
        }
        return next;
    }

    // Display all pending requests
    public void displayQueue() {
        System.out.println("=== Pending Booking Requests ===");
        if (queue.isEmpty()) {
            System.out.println("No requests.");
        } else {
            for (Reservation r : queue) {
                System.out.println(r);
            }
        }
    }
}

package com.bookmystay.services;

import java.util.*;

public class ServiceManager {
    private Map<String, List<Service>> reservationServices = new HashMap<>();

    // Attach a service to a reservation ID
    public void addService(String reservationId, Service service) {
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
        System.out.println("Added service " + service + " to reservation " + reservationId);
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {
        System.out.println("=== Services for " + reservationId + " ===");
        List<Service> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());
        if (services.isEmpty()) {
            System.out.println("No services attached.");
        } else {
            for (Service s : services) {
                System.out.println(s);
            }
        }
    }

    // Calculate total additional cost
    public double calculateCost(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>())
                .stream()
                .mapToDouble(Service::getCost)
                .sum();
    }
}

# BookMyStayApp
# UC4 – Reservation Confirmation & Room Allocation

## Overview
Confirms reservations by assigning unique room IDs and updating inventory.

## Key Features
- Assign unique room IDs
- Prevent reuse of room IDs
- Update availability immediately

## Data Structures
- 'Set<String>' → booked room IDs
- 'HashMap<String, Set<String>>' → room type → assigned rooms

## Actors
- Booking Service
- Inventory Service

## Benefits
- Strong booking integrity
- Instant inventory sync
- Conflict-free allocations

# BookMyStayApp
# UC2 – Room Search & Availability Check

## Overview
Adds a 'SearchService' for guests to view available rooms and pricing without mutating inventory.

## Key Features
- Display available room types
- Show pricing and amenities
- Prevent booking unavailable rooms

## Data Structures
- 'HashMap<String, Integer>' → Room type → available count
- 'HashMap<String, Double>' → Room type → price per night

## Actors
- Guest
- Search Service

## Benefits
- Read-only access
- Accurate availability
- Fast response time

# BookMyStayApp
# UC1 – Room Inventory Setup & Management

## Overview
Implements the hotel room inventory system using `HashMap` for fast lookup of room counts and prices.

## Key Features
- Initialize room types (Single, Double, Suite)
- Store room counts and prices
- Support dynamic inventory updates
- Provide real-time availability status

## Data Structures
- `HashMap<String, Integer>` → Room type → available count
- `HashMap<String, Double>` → Room type → price per night

## Actors
- Hotel Admin
- Inventory Service

## Benefits
- O(1) inventory access
- Clean separation of room data
- Easy scalability for new room types

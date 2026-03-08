# BookMyStayApp
# UC5 – Add-On Service Selection

## Overview
Allows guests to attach optional services (e.g., breakfast, spa, pickup) to reservations.

## Key Features
- Attach multiple services per booking
- Calculate additional cost
- Flexible service attachment

## Data Structures
- `Map<String, List<Service>>` → reservation ID → services

## Actors
- Guest
- Service Management Module

## Benefits
- Clean reservation-service mapping
- Easy future expansion
- Accurate billing

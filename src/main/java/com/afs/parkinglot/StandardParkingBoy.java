package com.afs.parkinglot;

import java.util.List;

public record StandardParkingBoy(List<ParkingLot> parkingLots) {

    public ParkingTicket park(Car car) {
        for (ParkingLot lot : parkingLots) {
            ParkingTicket ticket = lot.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        System.out.println("No available position.");
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        for (ParkingLot lot : parkingLots) {
            if (lot.equals(ticket.parkingLot())) {
                return lot.fetch(ticket);
            }
        }
        System.out.println("Unrecognized parking ticket.");
        return null;
}
    }

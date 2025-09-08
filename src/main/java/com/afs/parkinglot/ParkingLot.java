package com.afs.parkinglot;

public class ParkingLot {
    public ParkingTicket park(Car car) {
        return new ParkingTicket(car);
    }
}

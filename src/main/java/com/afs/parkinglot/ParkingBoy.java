package com.afs.parkinglot;

public record ParkingBoy(ParkingLot parkingLot) {
    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }
    public Car fetch(ParkingTicket ticket) {
        return parkingLot.fetch(ticket);
    }
}

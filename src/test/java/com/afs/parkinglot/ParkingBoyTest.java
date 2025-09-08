package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    @Test
    public void should_return_ticket_when_park_given_available_position() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("粤A12345");
        ParkingTicket ticket = new ParkingTicket(car, 1, parkingLot);

        ParkingTicket expectedTicket = parkingBoy.park(car);

        assertEquals(ticket, expectedTicket);
    }
}

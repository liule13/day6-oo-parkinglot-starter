package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardParkingBoyTest {
    // AC: When the first parking lot has available positions, park into the first lot.
    @Test
    public void should_park_in_first_lot_when_has_space() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car("粤A12345");

        ParkingTicket ticket = new ParkingTicket(car, 1, parkingLot1);
        ParkingTicket expectedTicket = standardParkingBoy.park(car);
        assertEquals(ticket, expectedTicket);
    }

}

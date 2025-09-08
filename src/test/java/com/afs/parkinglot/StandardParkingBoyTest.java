package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

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

    // AC: When the first parking lot is full, park into the second lot.
    @Test
    public void should_park_in_second_lot_when_first_lot_full() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car("粤A12345");
        Car car2 = new Car("粤B12345");
        standardParkingBoy.park(car1);
        ParkingTicket ticket = new ParkingTicket(car2, 1, parkingLot2);
        ParkingTicket expectedTicket2 = standardParkingBoy.park(car2);
        assertEquals(ticket, expectedTicket2);
    }

    // AC: When all parking lots are full, return null and print "No available position.".
    @Test
    public void should_return_null_when_all_lots_full() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car("粤A12345");
        Car car2 = new Car("粤B12345");
        Car car3 = new Car("粤C12345");
        standardParkingBoy.park(car1);
        standardParkingBoy.park(car2);
        ParkingTicket ticket = standardParkingBoy.park(car3);
        assertNull(ticket);
        assertTrue(outContent.toString().contains("No available position."));
    }

    // AC: Given a parking ticket and the parking lot has a parked car, when fetching, then return the car.
    @Test
    public void should_return_car_when_fetch_given_valid_ticket() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car("粤A12345");
        ParkingTicket ticket = standardParkingBoy.park(car);

        Car fetchedCar = standardParkingBoy.fetch(ticket);

        assertEquals(car, fetchedCar);
    }

}

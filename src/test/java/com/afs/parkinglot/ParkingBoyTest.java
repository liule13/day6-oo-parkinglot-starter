package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    // AC: Given a parking ticket and the parking lot has available positions, when parking, then returned after parking a car.
    @Test
    public void should_return_ticket_when_park_given_available_position() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("粤A12345");
        ParkingTicket ticket = new ParkingTicket(car, 1, parkingLot);

        ParkingTicket expectedTicket = parkingBoy.park(car);

        assertEquals(ticket, expectedTicket);
    }

    // AC: Given a parking ticket and the parking lot has a parked car, when fetching, then return the car.
    @Test
    public void should_return_car_when_fetch_given_valid_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("粤A12345");
        ParkingTicket ticket = parkingBoy.park(car);

        Car fetchedCar = parkingBoy.fetch(ticket);

        assertEquals(car, fetchedCar);
    }

    // AC: Given a parking ticket and the parking lot is full, when parking, then return null and print "No available position.".
    @Test
    public void should_return_null_when_park_given_full_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car("粤A12345");
        Car car2 = new Car("粤B12345");
        parkingBoy.park(car1);

        ParkingTicket ticket2 = parkingBoy.park(car2);

        assertNull(ticket2);
        assertTrue(outContent.toString().contains("No available position."));
    }

    // AC: Given a wrong or used parking ticket, when fetching, then return null and print "Unrecognized parking ticket.".
    @Test
    public void should_return_null_when_fetch_given_wrong_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("粤A12345");
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket(new Car("粤B12345"), 2, parkingLot);

        Car fetchedCar = parkingBoy.fetch(wrongTicket);

        assertNull(fetchedCar);
        assertTrue(outContent.toString().contains("Unrecognized parking ticket."));
    }
}

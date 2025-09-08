package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {
    @Test
    public void should_return_a_parking_ticket_when_park_given_a_parking_lot_with_available_position() {
        //given
        Car car = new Car("粤A12345");
        ParkingLot parkingLot = new ParkingLot();
        //when
        ParkingTicket ticket = new ParkingTicket(car, 1, parkingLot);
        //then
        ParkingTicket expectedTicket = parkingLot.park(car);
        assertEquals(ticket, expectedTicket);
    }

    @Test
    public void should_return_a_parked_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("粤A12345");
        ParkingTicket ticket = parkingLot.park(car);
        //when
        Car parkedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car, parkedCar);
    }

    @Test
    public void should_return_right_car_when_fetch_two_car_with_two_parked_car_and_two_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("粤A12345");
        Car car2 = new Car("粤B12345");
        ParkingTicket ticket = parkingLot.park(car);
        ParkingTicket ticket2 = parkingLot.park(car2);
        //when
        Car parkedCar = parkingLot.fetch(ticket);
        Car parkedCar2 = parkingLot.fetch(ticket2);
        //then
        assertEquals(car, parkedCar);
        assertEquals(car2, parkedCar2);
    }

    @Test
    public void should_return_null_when_fetch_car_with_wrong_or_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("粤A12345111");
        ParkingTicket ticket = new ParkingTicket(car, 1, parkingLot);
        //when
        Car parkedCar = parkingLot.fetch(ticket);
        //then
        assertNull(parkedCar);
    }

    @Test
    public void should_return_null_when_park_car_with_full_capacity_parking_log() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("粤A12345111");
        Car car2 = new Car("粤A12345112");
        ParkingTicket ticket = new ParkingTicket(car, 1, parkingLot);
        //when
        ParkingTicket parkedCar = parkingLot.park(car);
        ParkingTicket parkedCar2 = parkingLot.park(car2);
        //then
        assertEquals(ticket, parkedCar);
        assertNull(parkedCar2);
    }
}

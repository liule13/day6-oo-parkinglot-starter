package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}

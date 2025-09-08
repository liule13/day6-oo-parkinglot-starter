package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotTest {
    @Test
    public void should_return_a_parking_ticket_when_park_given_a_parking_lot_with_available_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("粤A12345");
        //when
        ParkingTicket ticket = parkingLot.park(car);
        //then
        assertEquals(car.getCarNumber(), ticket.getCarNumber());
    }
    @Test
    public void should_return_a_parked_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_a_ticket () {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("粤A12345");
        ParkingTicket ticket = new ParkingTicket(car);
        //when
        Car parkedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car.getCarNumber(), parkedCar.getCarNumber());
    }
}

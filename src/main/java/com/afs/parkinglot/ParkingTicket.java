package com.afs.parkinglot;

public class ParkingTicket {
    private Car car;
    public ParkingTicket(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public String getCarNumber() {
        return  car.getCarNumber();
    }
}

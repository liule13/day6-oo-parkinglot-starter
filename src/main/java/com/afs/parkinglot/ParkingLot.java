package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private final int CAPACITY = 10;
    private Integer capacity = CAPACITY;
    private Map<ParkingTicket,Car> ticketCars = new HashMap<ParkingTicket,Car>();
    public  ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }
    public  ParkingLot() {
    }
    public ParkingTicket park(Car car) {
        return IntStream.rangeClosed(1, capacity)
                .boxed().filter(position -> ticketCars.keySet().stream().noneMatch(ticket -> ticket.position().equals(position)))
                .findFirst()
                .map(position -> {
                    ParkingTicket ticket = new ParkingTicket(car, position, this);
                    ticketCars.put(ticket, car);
                    return ticket;
                }).orElse(null);
    }

    public Car fetch(ParkingTicket ticket) {
        return ticketCars.remove(ticket);
    }
}

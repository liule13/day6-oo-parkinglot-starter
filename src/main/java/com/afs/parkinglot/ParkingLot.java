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
        boolean isFull = ticketCars.size() >= capacity;
        if (isFull) {
            System.out.println("NNo available position.");
            return null;
        }
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
        if (!ticketCars.containsKey(ticket)) {
            System.out.println("Unrecognized parking ticket.");
            return null;
        }
        return ticketCars.remove(ticket);
    }
}

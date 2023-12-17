package com.cinema23738.cinema.model;

import lombok.Data;

@Data
public class SeatReservation {

    private String seat;
    private boolean active;

    public boolean isActive() {
        return active;
    }
}
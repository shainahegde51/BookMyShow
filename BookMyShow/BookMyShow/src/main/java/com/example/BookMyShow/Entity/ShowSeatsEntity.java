package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.BookMyShow.enums.SeatType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="ShowSeats")
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int rate;

    @NotNull
    private String seatNum;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SeatType seatType;

    @NotNull
    private boolean booked;

    @NotNull
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;


}

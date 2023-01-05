package com.example.BookMyShow.Entity;

import com.example.BookMyShow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="TheatreSeats")
public class TheaterSeatsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String seatNum;
    private int rate;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name="fk_theatreId")
    @JsonIgnore
    private TheaterEntity theatre;
}

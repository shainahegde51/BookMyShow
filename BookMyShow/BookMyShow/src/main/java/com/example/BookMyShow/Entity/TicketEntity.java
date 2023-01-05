package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String allotedSeat;
    private int amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedAt;

    @ManyToOne
    @JoinColumn(name="fk_userId")
    @JsonIgnore
    private  UserEntity user;

    @ManyToOne
    @JoinColumn(name="fk_showId")
    @JsonIgnore
    private ShowEntity shows;

    @OneToMany( mappedBy = "ticket",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;

}

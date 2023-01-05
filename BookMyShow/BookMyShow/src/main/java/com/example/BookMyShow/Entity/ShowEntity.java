package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Shows")
public class ShowEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date showDate;

    @Column(columnDefinition = "TIME", nullable = false)
    private Time showTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    @JsonIgnore
    List<TicketEntity> tickets;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> showSeats;

    @ManyToOne
    @JsonIgnore
    private MovieEntity movie;

    @ManyToOne
    @JsonIgnore
    private TheaterEntity theatre;



}

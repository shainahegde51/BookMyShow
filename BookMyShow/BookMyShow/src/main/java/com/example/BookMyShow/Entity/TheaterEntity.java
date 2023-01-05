package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import com.example.BookMyShow.enums.TheaterType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Theatre")
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String theatreName;
    @Enumerated(EnumType.STRING)
    private TheaterType theaterType;
    private String address;
    private String city;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatsEntity> theatreSeats = new ArrayList<>();;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;

}

package com.example.BookMyShow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="Movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String movieName;
    @Column(columnDefinition = "DATE")
    private Date releaseDate;

    @OneToMany(mappedBy = "movie",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;

}

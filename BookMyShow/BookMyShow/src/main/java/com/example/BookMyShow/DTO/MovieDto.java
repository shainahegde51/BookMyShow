package com.example.BookMyShow.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieDto {
    private int id;
    private String movieName;
    private Date releaseDate;
    private List<ShowDto> shows;
}

package com.example.BookMyShow.DTO;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShowDto {
    private int id;
    private Date showDate;
    private Time showTime;
    MovieDto movieDto;
    TheaterDto theatreDto;

}

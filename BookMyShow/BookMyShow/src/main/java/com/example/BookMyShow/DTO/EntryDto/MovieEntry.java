package com.example.BookMyShow.DTO.EntryDto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntry {
     String movieName;
       Date releaseDate;
}

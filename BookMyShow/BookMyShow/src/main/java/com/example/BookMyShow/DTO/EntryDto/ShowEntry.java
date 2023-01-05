package com.example.BookMyShow.DTO.EntryDto;

import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowEntry {
    @NotNull
    Date showDate;

    @NotNull
   Time showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheaterResponseDto theaterResponseDto;

}

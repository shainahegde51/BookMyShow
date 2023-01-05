package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponseDto {

    int id;
    Date showDate;
    Time showTime;
    MovieResponseDto movieResponseDto;
    TheaterResponseDto theaterDto;

}

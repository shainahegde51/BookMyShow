package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDto {

    int id;
    String movieName;
    Date releaseDate;

    //Optional
    List<ShowResponseDto> showDtoList;
}


package com.example.BookMyShow.DTO.ResponseDto;

import com.example.BookMyShow.enums.TheaterType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterResponseDto {
    int id;
    String theaterName;
    String address;
    String city;
    TheaterType type;
}

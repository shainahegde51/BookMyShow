package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieNameAndIdObject {
    int id;
    String name;
}

package com.example.BookMyShow.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private int id;
    private String name;
    private long phNum;

}

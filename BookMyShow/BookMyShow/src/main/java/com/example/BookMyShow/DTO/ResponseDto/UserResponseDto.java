package com.example.BookMyShow.DTO.ResponseDto;

import com.example.BookMyShow.DTO.TicketDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private long phNum;
    List<TicketDto> tickets;
}

package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketDto {

    private int ticketId;
    private String allotedSeat;
    private int amount;
    private Date bookedDate;

   // ShowDto showDto;
   // UserDto userDto;
   ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto;
}

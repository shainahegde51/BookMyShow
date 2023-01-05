package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponseDto {
    int id;
    String allotedSeats;
    int amount;
     private Date bookedDate;
     String userName;
    String movieName;
}

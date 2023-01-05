package com.example.BookMyShow.DTO;

import com.example.BookMyShow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDto {
    int userId;
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;


}

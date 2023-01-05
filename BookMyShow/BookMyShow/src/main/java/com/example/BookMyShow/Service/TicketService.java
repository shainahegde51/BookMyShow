package com.example.BookMyShow.Service;


import com.example.BookMyShow.DTO.BookTicketRequestDto;
import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.DTO.TicketDto;


public interface TicketService {
    //public TicketDto addTicket(TicketDto ticketDto);
    public TicketResponseDto getTicketById(int id);
    public TicketResponseDto bookTicket(BookTicketRequestDto bookRequestDto);
}

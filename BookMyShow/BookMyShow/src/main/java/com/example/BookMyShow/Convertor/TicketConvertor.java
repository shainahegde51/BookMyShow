package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.DTO.TicketDto;
import com.example.BookMyShow.Entity.TicketEntity;

public class TicketConvertor {
    public static TicketEntity dtoToEntity(TicketDto ticketDto) {
    return TicketEntity.builder()
            .allotedSeat(ticketDto.getAllotedSeat())
            .amount(ticketDto.getAmount())
            .bookedAt(ticketDto.getBookedDate()).build();
    }

    public static TicketResponseDto entityToDto(TicketEntity ticketEntity) {

        return TicketResponseDto.builder()
                .id(ticketEntity.getId())
                .bookedDate(ticketEntity.getBookedAt())
                .allotedSeats(ticketEntity.getAllotedSeat())
               .movieName(ticketEntity.getShows().getMovie().getMovieName())
                .userName(ticketEntity.getUser().getName())
                .amount(ticketEntity.getAmount()).build();
    }
}

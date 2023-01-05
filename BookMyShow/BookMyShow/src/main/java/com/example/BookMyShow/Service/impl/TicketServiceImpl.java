package com.example.BookMyShow.Service.impl;


import com.example.BookMyShow.Convertor.TicketConvertor;
import com.example.BookMyShow.DTO.BookTicketRequestDto;
import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.DTO.TicketDto;

import com.example.BookMyShow.Repository.ShowRepo;
import com.example.BookMyShow.Repository.TicketRepo;

import com.example.BookMyShow.Repository.UserRepo;
import com.example.BookMyShow.Entity.ShowEntity;
import com.example.BookMyShow.Entity.ShowSeatsEntity;
import com.example.BookMyShow.Entity.TicketEntity;
import com.example.BookMyShow.Entity.UserEntity;
import com.example.BookMyShow.Service.TicketService;
import com.example.BookMyShow.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ShowRepo showRepo;

//    @Override
//    public TicketDto addTicket(TicketDto ticketDto) {
//        TicketEntity ticketEntity= TicketConvertor.dtoToEntity(ticketDto);
//       ticketRepo.save(ticketEntity);
//       return ticketDto;
//    }

    @Override
    public TicketResponseDto getTicketById(int id) {
        TicketEntity ticketEntity =  ticketRepo.findById(id).get();
        return TicketConvertor.entityToDto(ticketEntity);
    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookRequestDto) {
       UserEntity userEntity= userRepo.findById(bookRequestDto.getUserId()).get();
        ShowEntity showEntity=showRepo.findById(bookRequestDto.getShowId()).get();
        SeatType seatType=bookRequestDto.getSeatType();

       Set<String> requestedSeats=bookRequestDto.getRequestedSeats();
        List<ShowSeatsEntity> showSeats=showEntity.getShowSeats();
        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat:showSeats){
            if(!seat.isBooked() &&
            seat.getSeatType().equals(bookRequestDto.getSeatType()) &&
            requestedSeats.contains(seat.getSeatNum())){
                bookedSeats.add(seat);
            }
        }
        //print the booked seats
        for(ShowSeatsEntity seat: bookedSeats)
            System.out.println(seat.getSeatNum());

        if(bookedSeats.size() != requestedSeats.size()){
            throw new Error("All Seats are not available");
        }
        TicketEntity ticketEntity=TicketEntity.builder().user(userEntity).shows(showEntity).seats(bookedSeats).build();

        int amount=0;
        for(ShowSeatsEntity showSeatsEntity:bookedSeats){
            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt( new Date());
            showSeatsEntity.setTicket(ticketEntity);
            amount= amount+showSeatsEntity.getRate();
        }
        ticketEntity.setAmount(amount);
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllotedSeat((convertListOfSeatsEntityToString(bookedSeats)));

        userEntity.getTickets().add(ticketEntity);
        showEntity.getTickets().add(ticketEntity);

       ticketRepo.save(ticketEntity);
        TicketResponseDto ticketResponseDto = TicketConvertor.entityToDto(ticketEntity);

        //ticketResponseDto.setMovieName(showEntity.getMovie().getMovieName());
        //ticketResponseDto.setUserName(userEntity.getName());

        return ticketResponseDto;
    }
    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNum()+" ";
        }

        return str;

    }


}

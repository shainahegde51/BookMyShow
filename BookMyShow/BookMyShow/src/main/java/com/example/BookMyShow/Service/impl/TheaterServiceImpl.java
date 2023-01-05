package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Convertor.TheatreConvertor;
import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.Repository.TheaterRepo;
import com.example.BookMyShow.Repository.TheaterSeatsRepo;
import com.example.BookMyShow.Entity.TheaterEntity;
import com.example.BookMyShow.Entity.TheaterSeatsEntity;
import com.example.BookMyShow.Service.TheaterService;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheaterType;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepo theatreRepo;
    @Autowired
    TheaterSeatsRepo theatreSeatsRepo;

    @Override
    public TheaterResponseDto addTheatre(TheatreEntry theatreEntryDto) {
        TheaterEntity theaterEntity= TheatreConvertor.dtoToEntity(theatreEntryDto);
        List<TheaterSeatsEntity> theatreSeats =createTheatreSeats();

        theaterEntity.setTheatreSeats(theatreSeats);
        theaterEntity.setShows(null);

        for(TheaterSeatsEntity theatreSeat:theatreSeats){
            theatreSeat.setTheatre(theaterEntity);
        }

      //
        //  theaterEntity.setTheaterType(TheaterType.SINGLE);
        log.info("The theater entity is "+ theaterEntity);

        theaterEntity=theatreRepo.save(theaterEntity);
        theatreSeatsRepo.saveAll(theatreSeats);
        return TheatreConvertor.entityToDto(theaterEntity);

    }

    public List<TheaterSeatsEntity> createTheatreSeats() {
        List<TheaterSeatsEntity> seats=new ArrayList<>();
        seats.add(createTheatreSeat("A1",100,SeatType.CLASSIC));
        seats.add(createTheatreSeat("A2",100,SeatType.CLASSIC));
        seats.add(createTheatreSeat("A3",100,SeatType.CLASSIC));

        seats.add(createTheatreSeat("B1",200,SeatType.PREMIUM));
        seats.add(createTheatreSeat("B2",200,SeatType.PREMIUM));
        seats.add(createTheatreSeat("B3",200,SeatType.PREMIUM));
        return seats;

    }
    public TheaterSeatsEntity createTheatreSeat(String seatNum, int rate, SeatType seatType){
        return TheaterSeatsEntity.builder().seatNum(seatNum).rate(rate).seatType(seatType).build();
    }
    @Override
    public TheaterResponseDto getTheatreById(int id) {
        TheaterEntity theatreEntity=theatreRepo.findById(id).get();
        return TheatreConvertor.entityToDto(theatreEntity);
    }
}

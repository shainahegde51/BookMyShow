package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Convertor.ShowConvertor;
import com.example.BookMyShow.DTO.EntryDto.ShowEntry;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.Entity.*;
import com.example.BookMyShow.Repository.MovieRepo;
import com.example.BookMyShow.Repository.ShowRepo;
import com.example.BookMyShow.Repository.ShowSeatsRepo;
import com.example.BookMyShow.Repository.TheaterRepo;
import com.example.BookMyShow.Service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TheaterRepo theatreRepo;

    @Autowired
    ShowSeatsRepo showSeatsRepo;

    @Override
    public ShowResponseDto addShow(ShowEntry showEntry) {
        log.info("from ShowControllerimpli");
        ShowEntity showEntity = ShowConvertor.dtoToEntity(showEntry);

        MovieEntity movieEntity = movieRepo.findById(showEntry.getMovieResponseDto().getId()).get();

        TheaterEntity theatreEntity = theatreRepo.findById(showEntry.getTheaterResponseDto().getId()).get();
        // adding movie and theatre to the show
        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        showEntity = showRepo.save(showEntity);
        List<ShowSeatsEntity> showSeatsEntity = createShowSeatsEntity(theatreEntity.getTheatreSeats(), showEntity);

        showSeatsRepo.saveAll(showSeatsEntity);
        ShowResponseDto showResponseDto = ShowConvertor.entityToDto(showEntity, showEntry);

       return showResponseDto;
    }


    public List<ShowSeatsEntity> createShowSeatsEntity(List<TheaterSeatsEntity> theatreSeats, ShowEntity showEntity) {
        List<ShowSeatsEntity> showSeats = new ArrayList<>();
        // adding same set of theater seats to show seats
        for (TheaterSeatsEntity seat : theatreSeats) {

            ShowSeatsEntity showSeatsEntity=ShowSeatsEntity.builder()
                   // .id(seat.getId())
                    .seatNum(seat.getSeatNum())
                    .rate(seat.getRate())
                    .seatType(seat.getSeatType())
                    //.bookedAt(new Date())
                   // .show(showEntity)
                    .build();

            showSeats.add( showSeatsEntity);
        }
        //We need to set the show Entity for each of the ShowSeat....
        for (ShowSeatsEntity showSeatsEntity : showSeats) {
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setShowSeats(showSeats);
        return showSeats;
    }

    @Override
    public ShowResponseDto getShowById(int id) {
       ShowEntity showEntity=showRepo.findById(id).get();
       // adding movieresponsedto
        MovieResponseDto movieResponseDto=null;
        MovieEntity movieEntity=movieRepo.findById(id).get();
System.out.print(movieEntity.getMovieName());
        movieResponseDto.setMovieName(movieEntity.getMovieName());
        movieResponseDto.setId(movieEntity.getId());
        movieResponseDto.setReleaseDate(movieEntity.getReleaseDate());

        //adding theatreResponseDto
        TheaterResponseDto theaterResponseDto=null;
        TheaterEntity theatreEntity=theatreRepo.findById(id).get();

        theaterResponseDto.setId(theatreEntity.getId());
        theaterResponseDto.setTheaterName(theatreEntity.getTheatreName());
        theaterResponseDto.setAddress(theatreEntity.getAddress());
        theaterResponseDto.setCity(theatreEntity.getCity());
        theaterResponseDto.setType(theatreEntity.getTheaterType());

          ShowResponseDto showResponseDto= ShowConvertor.entityToDto(showEntity);
          showResponseDto.setMovieResponseDto(movieResponseDto);
          showResponseDto.setTheaterDto(theaterResponseDto);

          return showResponseDto;

    }
}


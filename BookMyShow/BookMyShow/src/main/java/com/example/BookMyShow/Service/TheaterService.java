package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;


public interface TheaterService {
    TheaterResponseDto addTheatre(TheatreEntry theatreEntryDto);
    TheaterResponseDto getTheatreById(int id);
}

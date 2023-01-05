package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.ShowEntry;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;


public interface ShowService {
   ShowResponseDto addShow(ShowEntry showDto);
   ShowResponseDto getShowById(int id);
}

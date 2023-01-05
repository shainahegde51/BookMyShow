package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.MovieEntry;
import com.example.BookMyShow.DTO.MovieDto;
import com.example.BookMyShow.DTO.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;


public interface MovieService {
    public MovieResponseDto addMovie(MovieEntry movieEntry);
    public MovieResponseDto getMovieById(int id);
    MovieNameAndIdObject getNameAndId(int id);
}

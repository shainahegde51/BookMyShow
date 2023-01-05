package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.MovieEntry;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser (@RequestBody MovieEntry movieEntry){
        movieService.addMovie(movieEntry);
        return new ResponseEntity<>("Movie added Succesfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getUser(@PathVariable(value = "id")int id){

        MovieResponseDto movieResponseDto = movieService.getMovieById(id);
        return new ResponseEntity<>(movieResponseDto,HttpStatus.OK);
    }
}

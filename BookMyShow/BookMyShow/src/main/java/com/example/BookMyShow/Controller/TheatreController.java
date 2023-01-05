package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.Service.impl.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheaterServiceImpl theatreService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser (@RequestBody TheatreEntry theatreEntryDto){
        theatreService.addTheatre(theatreEntryDto);
        return new ResponseEntity<>("Theater added Succesfully", HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<TheaterResponseDto> getUser(@PathVariable(value = "id")int id){

        TheaterResponseDto theaterResponseDto = theatreService.getTheatreById(id);
        return new ResponseEntity<>(theaterResponseDto,HttpStatus.OK);
    }

}

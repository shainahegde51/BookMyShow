package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.ShowEntry;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Service.impl.ShowServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("show")
public class ShowController {

   @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntry showEntryDto){

        log.info("from ShowController");

        return showService.addShow(showEntryDto);
    }
    @GetMapping("{id}")
    public ResponseEntity<ShowResponseDto> getShow(@PathVariable(value = "id")int id){

       ShowResponseDto showResponseDto = showService.getShowById(id);
        return new ResponseEntity<>(showResponseDto, HttpStatus.OK);
    }
}

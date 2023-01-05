package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.BookTicketRequestDto;
import com.example.BookMyShow.DTO.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.Service.impl.TicketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("{id}")
    public TicketResponseDto getTicketById(@PathVariable int id){

        return ticketService.getTicketById(id);
    }

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){


        log.info("In controller");
        return ticketService.bookTicket(bookTicketRequestDto);

    }
}


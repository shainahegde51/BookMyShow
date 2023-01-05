package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser (@RequestBody UserEntry userEntry){
        userService.addUser(userEntry);
        return new ResponseEntity<>("User added Succesfully", HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}

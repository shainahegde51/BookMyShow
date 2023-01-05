package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;

public interface UserService {
     public void addUser(UserEntry userEntry);
     public UserResponseDto getUserById(int id);
}

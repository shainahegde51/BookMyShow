package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Convertor.UserConvertor;
import com.example.BookMyShow.DTO.EntryDto.UserEntry;
import com.example.BookMyShow.DTO.ResponseDto.UserResponseDto;
import com.example.BookMyShow.Repository.UserRepo;
import com.example.BookMyShow.Entity.UserEntity;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public void addUser(UserEntry userEntry) {
    UserEntity userEntity= UserConvertor.dtoToEntity(userEntry);
    userRepo.save(userEntity);
    }

    @Override
    public UserResponseDto getUserById(int id) {
      UserEntity userEntity =  userRepo.findById(id).get();
      return UserConvertor.entityToDto(userEntity);
    }
}

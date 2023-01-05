package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.EntryDto.TheatreEntry;
import com.example.BookMyShow.DTO.ResponseDto.TheaterResponseDto;
import com.example.BookMyShow.Entity.TheaterEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConvertor {

    public static TheaterResponseDto entityToDto(TheaterEntity theatreEntity) {
         return TheaterResponseDto.builder().id(theatreEntity.getId())
                 .theaterName(theatreEntity.getTheatreName())
                 .address(theatreEntity.getAddress())
                 .city(theatreEntity.getCity())
                 .type(theatreEntity.getTheaterType())
                 .build();
    }

    public static TheaterEntity dtoToEntity(TheatreEntry theatreDto) {
        return TheaterEntity.builder().city(theatreDto.getCity()).address(theatreDto.getAddress()).theatreName(theatreDto.getTheatreName()).theaterType(theatreDto.getTheaterType()).build();
    }
}

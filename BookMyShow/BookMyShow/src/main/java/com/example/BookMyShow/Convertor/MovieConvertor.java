package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.EntryDto.MovieEntry;
import com.example.BookMyShow.DTO.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Entity.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConvertor {
    public static MovieEntity dtoToEntity(MovieEntry movieEntry){
        return MovieEntity.builder().movieName(movieEntry.getMovieName()).releaseDate(movieEntry.getReleaseDate()).build();
    }
    public static MovieResponseDto entityToDto(MovieEntity movieEntity){
        return MovieResponseDto.builder().id(movieEntity.getId()).movieName(movieEntity.getMovieName()).releaseDate(movieEntity.getReleaseDate()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity) {
        return MovieNameAndIdObject.builder().
                id(movieEntity.getId())
                .name(movieEntity.getMovieName()).build();
    }
}

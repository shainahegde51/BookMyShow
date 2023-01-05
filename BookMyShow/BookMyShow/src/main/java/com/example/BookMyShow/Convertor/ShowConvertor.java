package com.example.BookMyShow.Convertor;

import com.example.BookMyShow.DTO.EntryDto.ShowEntry;
import com.example.BookMyShow.DTO.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.Entity.ShowEntity;
import com.example.BookMyShow.Repository.ShowRepo;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

@UtilityClass
public class ShowConvertor {
    @Autowired
    ShowRepo showRepo;

    public static ShowResponseDto entityToDto(ShowEntity showEntity, ShowEntry showEntry) {
        return ShowResponseDto.builder()
               .id(showEntity.getId())
                .showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .movieResponseDto(showEntry.getMovieResponseDto())
                .theaterDto(showEntry.getTheaterResponseDto())
                .build();
    }

    public static ShowEntity dtoToEntity(ShowEntry showDto) {
        return ShowEntity.builder().showTime(showDto.getShowTime()).showDate(showDto.getShowDate()).build();
    }

    public static ShowResponseDto entityToDto(ShowEntity showEntity) {
        return ShowResponseDto.builder()
                .showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .id(showEntity.getId())
                .build();
    }

}



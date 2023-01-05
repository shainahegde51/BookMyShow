package com.example.BookMyShow.Service.impl;



import com.example.BookMyShow.Convertor.MovieConvertor;
import com.example.BookMyShow.DTO.EntryDto.MovieEntry;
import com.example.BookMyShow.DTO.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.DTO.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Repository.MovieRepo;
import com.example.BookMyShow.Entity.MovieEntity;
import com.example.BookMyShow.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepo movieRepo;

    @Override
    public MovieResponseDto addMovie(MovieEntry movieEntryDto) {

        MovieResponseDto movieResponseDto = null;
        if(movieRepo.existsBymovieName(movieEntryDto.getMovieName())){
            movieResponseDto.setMovieName("This movie is already Existing");
            return movieResponseDto;
        }
        log.info("In the function add movie "+ movieEntryDto);

        MovieEntity movieEntity= MovieConvertor.dtoToEntity(movieEntryDto);
       movieRepo.save(movieEntity);
        movieResponseDto = MovieConvertor.entityToDto(movieEntity);

        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovieById(int id) {
        MovieEntity movieEntity =  movieRepo.findById(id).get();
        return MovieConvertor.entityToDto(movieEntity);
    }
    public MovieNameAndIdObject getNameAndId(int id){

        //I need information from repo
        MovieEntity movieEntity = movieRepo.findById(id).get(); //Get this movieEntity from the database


        //I have to convert it

        MovieNameAndIdObject obj = MovieConvertor.convertEntityToThisObject(movieEntity);


        return obj;
    }
}

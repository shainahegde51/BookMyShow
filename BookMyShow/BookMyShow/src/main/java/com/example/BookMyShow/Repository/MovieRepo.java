package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity,Integer> {
 boolean existsBymovieName(String movieName);
}

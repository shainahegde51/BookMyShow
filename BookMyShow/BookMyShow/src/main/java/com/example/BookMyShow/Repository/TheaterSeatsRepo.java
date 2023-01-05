package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatsRepo extends JpaRepository<TheaterSeatsEntity,Integer> {
}

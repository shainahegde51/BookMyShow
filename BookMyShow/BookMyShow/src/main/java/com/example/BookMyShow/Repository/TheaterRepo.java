package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepo extends JpaRepository<TheaterEntity,Integer> {
}

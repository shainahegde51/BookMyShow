package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepo extends JpaRepository<ShowSeatsEntity,Integer> {
}

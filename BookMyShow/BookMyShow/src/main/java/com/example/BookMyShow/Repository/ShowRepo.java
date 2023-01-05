package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<ShowEntity,Integer> {
}

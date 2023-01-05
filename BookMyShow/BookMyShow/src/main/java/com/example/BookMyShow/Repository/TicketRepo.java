package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity,Integer> {
}

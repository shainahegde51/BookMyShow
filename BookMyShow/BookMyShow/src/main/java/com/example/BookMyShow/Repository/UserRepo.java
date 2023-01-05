package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
}

package com.example.BookMyShow.Entity;


import com.example.BookMyShow.Entity.TicketEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name ="user")
public class UserEntity {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phNum;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    @JsonIgnore
    List<TicketEntity> tickets;

}

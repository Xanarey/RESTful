package com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events", schema = "postgres")
public class Event {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

//    @Column(name = "created")
//    private LocalDateTime created;
//    @Column(name = "updated")
//    private LocalDateTime updated;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @OneToOne
//    @JoinColumn(name = "file_id")
//    private File file;

}

package com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events", schema = "postgres")
public class Event {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(name = "created")
    public String created = getLocalDateTime(getCreated());
    @Column(name = "updated")
    public String updated  = getLocalDateTime(getUpdated());

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File file;

    private String getLocalDateTime(String created) {
        return new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z")
                .format(new Date(System.currentTimeMillis()));
    }


}

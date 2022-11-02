package com.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "files", schema = "postgres")
public class File {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    @OneToOne(mappedBy = "file")
    private Event event;

}

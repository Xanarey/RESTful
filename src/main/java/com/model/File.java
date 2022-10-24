package com.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "files", schema = "postgres")
public class File {

    @Id @GeneratedValue(generator = "increment")
    private Long id;
    @Column(name = "url")
    private String url;

    public File() {}

    public File(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getUrl() {return url;}

    public void setUrl(String url) {this.url = url;}

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File file)) return false;
        return Objects.equals(getId(), file.getId()) && Objects.equals(getUrl(), file.getUrl());
    }

    @Override
    public int hashCode() {return Objects.hash(getId(), getUrl());}
}

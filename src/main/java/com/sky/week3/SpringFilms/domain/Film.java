package com.sky.week3.SpringFilms.domain;

import javax.persistence.*;

@Entity
public class Film {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @Column(name="releaseYear")   // year is a reserved keyword so need this for the field
    private Integer year;

    private String genre;

    public Film(Integer id, String title, Integer year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Film() {

    }

    public Film(String title, Integer year, String genre) {

        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }




}

package com.sky.week3.SpringFilms.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Review {

    private String title;
    private String content;


    @NotNull
    @ManyToOne(targetEntity = Film.class)
    private Film film;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Range(min=1, max=5)
    private Integer rating;

    public Review(int id, String title, String content, Integer rating, Film film) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.film = film;
    }

    public Review() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}

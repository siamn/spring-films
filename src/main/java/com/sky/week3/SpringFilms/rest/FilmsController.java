package com.sky.week3.SpringFilms.rest;

import com.sky.week3.SpringFilms.domain.Film;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class FilmsController {

    private List<Film> films = new ArrayList<>();


    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film film) {
        System.out.println(film);
        films.add(film);
        Film created = this.films.get(this.films.size() - 1);
        return new ResponseEntity<>(created, HttpStatus.CREATED) ;
    }


    @GetMapping("/get/{id}")
    public Film getById(@PathVariable Integer id) {
        System.out.println("ID: " + id);
        return films.get(id);
    }


}

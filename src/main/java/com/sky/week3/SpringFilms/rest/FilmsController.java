package com.sky.week3.SpringFilms.rest;

import com.sky.week3.SpringFilms.domain.Film;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Film>> create(@RequestBody List<Film> addFilms) {
        System.out.println(addFilms);
        System.out.println("Before: "+films);
        int initialSize = films.size();
        films.addAll(addFilms);
        System.out.println("After: "+films);
        List<Film> newFilms = films.subList(initialSize , films.size());
        return new ResponseEntity<>(newFilms, HttpStatus.CREATED) ;
    }


    @GetMapping("/get/{id}")
    public Film getById(@PathVariable Integer id) {
        System.out.println("ID: " + id);
        Film get = films.get(id);
        System.out.println(get);
        return get;
    }


    @GetMapping("/getAll")
    public List<Film> getAll() {
        System.out.println(films);
        return films;
    }


    @DeleteMapping("/remove/{id}")
    public Film remove(@PathVariable Integer id) {
        return films.remove((int) id);

    }


    @DeleteMapping("/remove")
    public Boolean remove(
            @PathParam("year") Integer year,
            @PathParam("title") String title,
            @PathParam("genre") String genre) {

        System.out.println("Title: "+title);
        System.out.println("Genre: "+genre);
        System.out.println("Year:"+ year);

        System.out.println("Before: "+films);
        int initialSize = films.size();
//        for (Film film : new ArrayList<>(films)) {
//            if ((film.getTitle().equals(title)) || ((film.getGenre().equals(genre)))
//            || (film.getYear().equals(year))) {
//                films.remove(film);
//            }
//        }

        films.removeIf(film -> (film.getTitle().equals(title))
                || film.getGenre().equals(genre)
                || film.getYear().equals(year));


        System.out.println("After: "+films);
        return films.size() < initialSize;
    }




}

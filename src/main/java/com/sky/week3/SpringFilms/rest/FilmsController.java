package com.sky.week3.SpringFilms.rest;

import com.sky.week3.SpringFilms.domain.Film;
import com.sky.week3.SpringFilms.services.FilmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;


@RestController
public class FilmsController {

    FilmsService service;

    public FilmsController(FilmsService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film film) {
        return new ResponseEntity<>(service.create(film), HttpStatus.CREATED) ;
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Film>> create(@RequestBody List<Film> addFilms) {
        return new ResponseEntity<>(service.create(addFilms), HttpStatus.CREATED) ;
    }


    @GetMapping("/get/{id}")
    public Film getById(@PathVariable Integer id) {
        return service.getById(id);
    }


    @GetMapping("/getAll")
    public List<Film> getAll() {
        return service.getAll();
    }


    @DeleteMapping("/remove/{id}")
    public Film remove(@PathVariable Integer id) {
        return service.remove(id);
    }


    @DeleteMapping("/remove")
    public Boolean remove(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "genre", required = false) String genre) {

        return service.remove(year, title, genre);
    }


}

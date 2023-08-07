package com.sky.week3.SpringFilms.rest;

import com.sky.week3.SpringFilms.domain.Review;
import com.sky.week3.SpringFilms.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World";
    }


    @PostMapping("/create")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return new ResponseEntity<>(this.service.create(review), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Review> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public Review getById(@PathVariable int id) {
        return this.service.getById(id);
    }

}
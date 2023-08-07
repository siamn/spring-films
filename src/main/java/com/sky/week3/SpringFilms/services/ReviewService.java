package com.sky.week3.SpringFilms.services;

import com.sky.week3.SpringFilms.domain.Film;
import com.sky.week3.SpringFilms.domain.Review;
import com.sky.week3.SpringFilms.repos.FilmRepo;
import com.sky.week3.SpringFilms.repos.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    public ReviewRepo repo;

    public ReviewService(ReviewRepo repo) {
        this.repo = repo;

    }

    public Review create(Review review) {
        return this.repo.save(review);

    }


    public List<Review> getAll() {
        return this.repo.findAll();
    }


    public Review getById(int id) {
        Review review = this.repo.findById(id).get();

        return review;
    }

}

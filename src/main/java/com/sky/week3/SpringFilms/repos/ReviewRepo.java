package com.sky.week3.SpringFilms.repos;

import com.sky.week3.SpringFilms.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {



}

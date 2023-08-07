package com.sky.week3.SpringFilms.repos;


import com.sky.week3.SpringFilms.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepo extends JpaRepository<Film, Integer> {

    List<Film> findByTitleContainsIgnoreCase(String title);

    Integer deleteByTitleOrGenreOrYear(String title, String genre, Integer year);

    @Query(value = "SELECT * FROM film WHERE genre = ?1", nativeQuery = true)  // native query test
    List<Film> findByGenre(String genre);

    @Query("SELECT f.year FROM Film f WHERE f.title = ?1 GROUP BY f.year")
    List<Integer> findYearByTitle(String title);

}

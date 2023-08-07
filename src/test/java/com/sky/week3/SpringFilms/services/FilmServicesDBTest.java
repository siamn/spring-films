package com.sky.week3.SpringFilms.services;


import com.sky.week3.SpringFilms.domain.Film;
import com.sky.week3.SpringFilms.repos.FilmRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest // boots the context (loads all the beans)
@ActiveProfiles("test")
public class FilmServicesDBTest {

    @Autowired
    private FilmsService service;

    @MockBean
    private FilmRepo repo;


    @Test
    void testUpdate() {
        int id = 1;
        Film existing = new Film(id, "Dune", 2021, "Action");
        String title = "Dune";
        int year = 1979;
        String genre = "Action";
        Film updated = new Film(id, title, year, genre);

        // WHEN
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        // THEN
        Assertions.assertEquals(updated, this.service.update(id, title, year, genre));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);
    }

    @Test
    void testRemove() {
        String title = "Dune";
        String genre = "Action";
        int year = 2021;
        Mockito.when(this.repo.deleteByTitleOrGenreOrYear(title,genre,year)).thenReturn(1);
        Assertions.assertEquals(1, this.service.remove(year, title, genre));
        Mockito.verify(this.repo, Mockito.times(1)).deleteByTitleOrGenreOrYear(title, genre, year);
    }


    @Test
    void testGetFilmByTitle() {
        String title = "Dune";
        Mockito.when(this.repo.findByTitleContainsIgnoreCase(title)).thenReturn(List.of(new Film()));
        Assertions.assertEquals(List.of(new Film()), this.service.getFilmByTitle(title));
        Mockito.verify(this.repo, Mockito.times(1)).findByTitleContainsIgnoreCase(title);
    }

    @Test
    void testGetFilmByGenre() {
        String genre = "Action";
        Mockito.when(this.repo.findByGenre(genre)).thenReturn(List.of(new Film()));
        Assertions.assertEquals(List.of(new Film()), this.service.getFilmByGenre(genre));
        Mockito.verify(this.repo, Mockito.times(1)).findByGenre(genre);
    }


    @Test
    void testGetByID() {
        int id = 1;
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(new Film()));

        Assertions.assertEquals(new Film(), this.service.getById(id));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }


}

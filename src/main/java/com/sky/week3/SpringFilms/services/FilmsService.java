package com.sky.week3.SpringFilms.services;

import com.sky.week3.SpringFilms.domain.Film;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FilmsService {


    Film create(Film film);

    List<Film> create(List<Film> addFilms);

    Film getById(int id);

    List<Film> getAll();


    Film remove(Integer id);

    Integer remove(Integer year, String title, String genre);

    List<Film> getFilmByTitle(String title);

    List<Film> getFilmByGenre(String genre);

    List<Integer> getYearByTitle(String title);


    Film update(int id, String title, int year, String genre);

}

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

    Boolean remove(Integer year, String title, String genre);

}

package com.sky.week3.SpringFilms.services;

import com.sky.week3.SpringFilms.domain.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmsServicesDB implements FilmsService {


    @Override
    public Film create(Film film) {
        return null;
    }

    @Override
    public List<Film> create(List<Film> addFilms) {
        return null;
    }

    @Override
    public Film getById(int id) {
        return null;
    }

    @Override
    public List<Film> getAll() {
        return null;
    }

    @Override
    public Film remove(Integer id) {
        return null;
    }

    @Override
    public Boolean remove(Integer year, String title, String genre) {
        return null;
    }
}

package com.sky.week3.SpringFilms.services;

import com.sky.week3.SpringFilms.domain.Film;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilmsServiceList implements FilmsService {

    private List<Film> films = new ArrayList<>();

    @Override
    public Film create(Film film) {
        System.out.println(film);
        films.add(film);
        Film created = this.films.get(this.films.size() - 1);
        return created;
    }

    @Override
    public List<Film> create(List<Film> addFilms) {
        System.out.println(addFilms);
        System.out.println("Before: "+films);
        int initialSize = films.size();
        films.addAll(addFilms);
        System.out.println("After: "+films);
        return films.subList(initialSize , films.size());
    }

    @Override
    public Film getById(int id) {
        System.out.println("ID: " + id);
        Film get = films.get(id);
        System.out.println(get);
        return get;
    }

    @Override
    public List<Film> getAll() {
        System.out.println(films);
        return films;
    }

    @Override
    public Film remove(Integer id) {
        return films.remove((int) id);
    }

    @Override
    public Boolean remove(Integer year, String title, String genre) {
        System.out.println("Title: "+title);
        System.out.println("Genre: "+genre);
        System.out.println("Year:"+ year);

        System.out.println("Before: "+films);
        int initialSize = films.size();

        films.removeIf(film -> (film.getTitle().equals(title))
                || film.getGenre().equals(genre)
                || film.getYear().equals(year));

        System.out.println("After: "+films);
        return films.size() < initialSize;
    }


    private List<Film> getFilmByMatchingString(String str) {
        List<Film> found = new ArrayList<>();
        for (Film film : films) {
            if (film.getTitle().equals(str)) {
                found.add(film);
            }
        }
        return found;
    }

    @Override
    public List<Film> getFilmByTitle(String title) {
        return getFilmByMatchingString(title);
    }

    @Override
    public List<Film> getFilmByGenre(String genre) {
        return getFilmByMatchingString(genre);
    }


}

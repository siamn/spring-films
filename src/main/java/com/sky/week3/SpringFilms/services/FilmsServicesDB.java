package com.sky.week3.SpringFilms.services;

import com.sky.week3.SpringFilms.domain.Film;
import com.sky.week3.SpringFilms.repos.FilmRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class FilmsServicesDB implements FilmsService {

    private FilmRepo repo;

    public FilmsServicesDB(FilmRepo repo) {
        this.repo = repo;
    }


    @Override
    public Film create(Film film) {
        return this.repo.save(film);
    }

    @Override
    public List<Film> create(List<Film> addFilms) {
        return this.repo.saveAll(addFilms);
    }

    @Override
    public Film getById(int id) {
        Optional<Film> optionalFilm = this.repo.findById(id);
        return optionalFilm.orElse(null);
    }

    @Override
    public List<Film> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Film remove(Integer id) {
        Film film = getById(id);
        this.repo.deleteById(id);
        return film;
    }

    @Override
    @Transactional
    public Boolean remove(Integer year, String title, String genre) {
        int initialSize = this.getAll().size();
        this.repo.deleteByTitleOrGenreOrYear(title, genre, year);
        return this.getAll().size() < initialSize;
    }

    @Override
    public List<Film> getFilmByTitle(String title) {
        return this.repo.findByTitleContainsIgnoreCase(title);
    }

    @Override
    public List<Film> getFilmByGenre(String genre) {
        return this.repo.findByGenre(genre);
    }
}

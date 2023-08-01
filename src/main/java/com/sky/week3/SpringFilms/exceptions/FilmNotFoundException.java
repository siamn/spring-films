package com.sky.week3.SpringFilms.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No film found with given ID")
public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException() {

    }

    public FilmNotFoundException(String message) {
        super(message);
    }

}

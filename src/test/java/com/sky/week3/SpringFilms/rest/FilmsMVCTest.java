package com.sky.week3.SpringFilms.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.week3.SpringFilms.domain.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the application context
@AutoConfigureMockMvc // create a MockMVC bean
@Sql(scripts = {"classpath:film-schema.sql", "classpath:film-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class FilmsMVCTest {


    @Autowired // tells spring to inject the MockMVC bean into this class
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void testCreate() throws Exception {
        Film film = new Film("Dune", 2021, "Action");
        System.out.println("DATA: " + film);
        String filmJSON = this.mapper.writeValueAsString(film);
        System.out.println("JSON: " + filmJSON);
        RequestBuilder req = MockMvcRequestBuilders.post("/create").content(filmJSON).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        Film responseBody = new Film(2, "Dune", 2021, "Action");
        System.out.println("DATA: " + responseBody);
        String responseBodyJSON = this.mapper.writeValueAsString(responseBody);
        System.out.println("JSON: " + responseBodyJSON);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(responseBodyJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreate2() throws Exception {
        String filmJSON = this.mapper.writeValueAsString(new Film("Dune", 2021, "Action"));
        String responseBodyJSON = this.mapper.writeValueAsString(new Film(2, "Dune", 2021, "Action"));
        this.mvc.perform(
                        MockMvcRequestBuilders.
                                post("/create")
                                .content(filmJSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(responseBodyJSON));
    }


    @Test
    void testRead() throws Exception {
        final int id = 1;
        String responseBody = this.mapper.writeValueAsString(new Film(id, "Dune", 2021,  "Action"));
        this.mvc.perform(get("/get/" + id))
                .andExpect(status().isOk())
                .andExpect(content().json(responseBody));
    }

}
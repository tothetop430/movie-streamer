package dev.chandraji.movies.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @GetMapping
    public String getAllMovies() {
        return "All Movies!";
    }

}

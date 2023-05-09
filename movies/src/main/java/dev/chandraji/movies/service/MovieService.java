package dev.chandraji.movies.service;

import dev.chandraji.movies.data.Movie;
import dev.chandraji.movies.data.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findAMovie(String id) {
        return movieRepository.findMovieByImdbId(id);
    }
}

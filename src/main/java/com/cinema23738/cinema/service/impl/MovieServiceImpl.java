package com.cinema23738.cinema.service.impl;

import com.cinema23738.cinema.model.Movie;
import com.cinema23738.cinema.model.Repertoire;
import com.cinema23738.cinema.repository.MovieRepository;
import com.cinema23738.cinema.repository.RepertoireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.cinema23738.cinema.service.MovieService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final RepertoireRepository repertoireRepository;

    @Override
    public String getMovies(final Model model) {
        final List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "movieIndex";
    }

    @Override
    public String addMovie(final Movie movie, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }
        movieRepository.save(movie);
        log.info("A new video has been added to the database " + movie.getTitle());
        return "redirect:/movies/list";
    }

    @Override
    public String showUpdateFormMovie(final long id, final Model model) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect ID: " + id));
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @Override
    public String updateMovie(final long id, final Movie movie) {
        final Movie movieFromDb = movieRepository.getOne(id);
        movieFromDb.setCategory(movie.getCategory());
        movieFromDb.setDescription(movie.getDescription());
        movieFromDb.setLength(movie.getLength());
        movieFromDb.setMinAge(movie.getMinAge());
        movieFromDb.setImageUrl(movie.getImageUrl());
        movieFromDb.setTitle(movie.getTitle());
        log.info("The video data has been edited " + movie.getTitle());
        return "redirect:/movies/list";
    }

    @Override
    public String deleteMovie(final long id, final Model model) {
        final List<Repertoire> repertoires = repertoireRepository.findByMovieId(id);
        repertoires.forEach(r -> repertoireRepository.deleteById(r.getId()));
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect ID : " + id));
        movieRepository.delete(movie);
        final List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        log.info("Deleted film " + movie.getTitle());
        return "movieIndex";
    }

    @Override
    public String showMovieRepertoireForm(final String movieName, final Model model) {
        final Movie movieRepertoire = movieRepository.findByTitle(movieName);
        model.addAttribute("movieRepertoire", movieRepertoire);
        model.addAttribute("repertoire", new Repertoire());
        return "movie-repertoire";
    }

    @Override
    public String addMovieRepertoire(final Repertoire repertoire, final Long movieId, final BindingResult result) {
        repertoire.setMovie(movieRepository.getOne(movieId));
        repertoireRepository.save(repertoire);
        log.info("Added repertoire for the film about ID " + movieId);
        return "redirect:/movies/list";
    }

    @Override
    public String showUpdateMovieRepertoireForm(final String movieName, final Long repertoireId, final Model model) {
        final Repertoire repertoire = repertoireRepository.getOne(repertoireId);
        final Movie movieRepertoire = movieRepository.findByTitle(movieName);
        model.addAttribute("movieRepertoire", movieRepertoire);
        model.addAttribute("repertoire", repertoire);
        return "movie-repertoire";
    }

    @Override
    public String updateMovieRepertoire(final Repertoire repertoire, final Long repertoireId, final BindingResult result) {
        final Repertoire repertoireFromDb = repertoireRepository.getOne(repertoireId);
        repertoireFromDb.setDate(repertoire.getDate());
        log.info("Repertoire data updated for " + repertoire.getMovie().getTitle());
        return "redirect:/movies/list";
    }

    @Override
    public String deleteMovieRepertoire(final Long repertoireId, final Model model) {
        repertoireRepository.deleteById(repertoireId);
        log.info("Repertoire with ID removed " + repertoireId);
        return "redirect:/movies/list";
    }
}
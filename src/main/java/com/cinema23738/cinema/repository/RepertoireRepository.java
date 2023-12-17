package com.cinema23738.cinema.repository;

import com.cinema23738.cinema.model.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {

    List<Repertoire> findByMovieId(final Long movieId);

    List<Repertoire> findBySpectacleId(final Long spectacleId);
}
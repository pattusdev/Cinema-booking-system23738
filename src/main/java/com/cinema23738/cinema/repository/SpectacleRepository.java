package com.cinema23738.cinema.repository;

import com.cinema23738.cinema.model.Spectacle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long> {

    Spectacle findByTitle(final String title);
}
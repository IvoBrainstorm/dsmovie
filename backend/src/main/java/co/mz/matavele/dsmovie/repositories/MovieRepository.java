package co.mz.matavele.dsmovie.repositories;

import co.mz.matavele.dsmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

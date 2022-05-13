package co.mz.matavele.dsmovie.repositories;

import co.mz.matavele.dsmovie.entities.Score;
import co.mz.matavele.dsmovie.entities.pk.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}

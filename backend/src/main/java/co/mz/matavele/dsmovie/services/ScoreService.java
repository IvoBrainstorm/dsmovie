package co.mz.matavele.dsmovie.services;

import co.mz.matavele.dsmovie.entities.Movie;
import co.mz.matavele.dsmovie.entities.Score;
import co.mz.matavele.dsmovie.entities.User;
import co.mz.matavele.dsmovie.entities.dto.MovieDTO;
import co.mz.matavele.dsmovie.entities.dto.ScoreDTO;
import co.mz.matavele.dsmovie.repositories.MovieRepository;
import co.mz.matavele.dsmovie.repositories.ScoreRepository;
import co.mz.matavele.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){
        User user = userRepository.findByEmail(scoreDTO.getEmail());

        if(user == null){
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0;
        for (Score scores : movie.getScores()){
            sum += score.getValue();
        }

        double avgScores = sum / movie.getScores().size();
        movie.setScore(avgScores);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }


}

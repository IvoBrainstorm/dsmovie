package co.mz.matavele.dsmovie.services;

import co.mz.matavele.dsmovie.entities.Movie;
import co.mz.matavele.dsmovie.entities.dto.MovieDTO;
import co.mz.matavele.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> result = movieRepository.findAll(pageable);
        Page<MovieDTO> list = result.map(x -> new MovieDTO(x));
        return list;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Movie result = movieRepository.findById(id).get();
        MovieDTO movie = new MovieDTO(result);
        return movie;
    }


}

package co.mz.matavele.dsmovie.controllers;

import co.mz.matavele.dsmovie.entities.dto.MovieDTO;
import co.mz.matavele.dsmovie.entities.dto.ScoreDTO;
import co.mz.matavele.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        MovieDTO movieDTO = scoreService.saveScore(dto);
        return movieDTO;
    }
}

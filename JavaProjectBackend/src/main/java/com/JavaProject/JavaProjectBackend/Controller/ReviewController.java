package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;
import com.JavaProject.JavaProjectBackend.Service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {
    private IReviewService _reviewService;

    @Autowired
    public ReviewController(IReviewService reviewService) {
        _reviewService = reviewService;
    }

    @GetMapping("/pokemon/{pokemonId}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviewsOfPokemon(@PathVariable(value = "pokemonId") int pokemonId) {
        List<ReviewDto> reviews = _reviewService.getReviewsByPokemonId(pokemonId);

        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/pokemon/{pokemonId}/review")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "pokemonId") int pokemonId, @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(_reviewService.createReview(pokemonId, reviewDto), HttpStatus.CREATED);
    }
}

package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
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

    @PostMapping("/pokemon/{pokemonId}/review/create")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "pokemonId") int pokemonId, @RequestBody ReviewDto reviewDto) {
        ReviewDto response = _reviewService.createReview(pokemonId, reviewDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/pokemon/{pokemonId}/reviews/{id}/update")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable(value = "pokemonId") int pokemonId, @PathVariable(value = "id") int reviewId, @RequestBody ReviewDto reviewDto) {
        ReviewDto response = _reviewService.updateReview(pokemonId, reviewId, reviewDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

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

    @PostMapping("/pokemon/{pokemonId}/reviews")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "pokemonId") int pokemonId, @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(_reviewService.createReview(pokemonId, reviewDto), HttpStatus.CREATED);
    }
}

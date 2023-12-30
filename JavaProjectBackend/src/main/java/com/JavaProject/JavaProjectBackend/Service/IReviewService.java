package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;

import java.util.List;
public interface IReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);
    List<ReviewDto> getReviewsByPokemonId(int pokemonId);
    ReviewDto updateReview(int pokemonId, int reviewId, ReviewDto reviewDto);


}

package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;

import java.util.List;
public interface IReviewService {
    ReviewDto getReviewById(int reviewId, int pokemonId);
    List<ReviewDto> getReviewsByPokemonId(int pokemonId);
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);
    ReviewDto updateReview(int pokemonId, int reviewId, ReviewDto reviewDto);
    void deleteReview(int pokemonId, int reviewId);
}

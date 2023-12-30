package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;

import java.util.List;
public interface IReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);
}

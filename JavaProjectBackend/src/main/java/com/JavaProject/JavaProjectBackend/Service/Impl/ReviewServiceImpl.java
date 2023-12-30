package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import com.JavaProject.JavaProjectBackend.Models.Review;
import com.JavaProject.JavaProjectBackend.Interface.IPokemonRepository;
import com.JavaProject.JavaProjectBackend.Interface.IReviewRepository;
import com.JavaProject.JavaProjectBackend.Service.IPokemonService;
import com.JavaProject.JavaProjectBackend.Service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReviewServiceImpl implements IReviewService {
    private IReviewRepository _reviewRepository;
    private IPokemonRepository _pokemonRepository;

    @Autowired
    public ReviewServiceImpl(IReviewRepository reviewRepository, IPokemonRepository pokemonRepository) {
        _reviewRepository = reviewRepository;
        _pokemonRepository = pokemonRepository;
    }

    @Override
    public List<ReviewDto> getReviewsByPokemonId(int pokemonId) {
        List<Review> reviews = _reviewRepository.findByPokemonId(pokemonId);

        return  reviews.stream().map(review -> mapToDto(review)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto createReview(int pokemonId, ReviewDto reviewDto) {
        Review review = mapToEntity(reviewDto);

        Pokemon pokemon = _pokemonRepository.findById(pokemonId).orElseThrow();

        review.setPokemon(pokemon);

        Review newReview = _reviewRepository.save(review);

        return mapToDto(newReview);
    }

    @Override
    public ReviewDto updateReview(int pokemonId, int reviewId, ReviewDto reviewDto) {
        Pokemon pokemon = _pokemonRepository.findById(pokemonId).orElseThrow();
        Review review = _reviewRepository.findById(reviewId).orElseThrow();

        if(review.getPokemon().getId() != pokemon.getId()){
           // throw new Exception("This review does not belong to a pokemon");
        }

        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());

        Review updateReview = _reviewRepository.save(review);

        return mapToDto(updateReview);
    }

    private ReviewDto mapToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(review.getStars());

        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = new Review();

        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());

        return review;
    }
}

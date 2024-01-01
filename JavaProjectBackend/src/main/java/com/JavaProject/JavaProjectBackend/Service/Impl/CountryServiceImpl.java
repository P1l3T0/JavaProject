package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;
import com.JavaProject.JavaProjectBackend.ErrorHandling.CountryNotFoundException;
import com.JavaProject.JavaProjectBackend.ErrorHandling.CustomExceptionHandlerImpl;
import com.JavaProject.JavaProjectBackend.ErrorHandling.ICustomExceptionHandler;
import com.JavaProject.JavaProjectBackend.Interface.ICountryRepository;
import com.JavaProject.JavaProjectBackend.Models.Country;
import com.JavaProject.JavaProjectBackend.Models.Owner;
import com.JavaProject.JavaProjectBackend.Models.Review;
import com.JavaProject.JavaProjectBackend.Service.ICountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements ICountryService {
    private ICountryRepository _countryRepository;

    public CountryServiceImpl(ICountryRepository countryRepository) {
        _countryRepository = countryRepository;
    }

    @Override
    public CountryDto getCountryById(int countryId) {
        Country country = _countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException("Country doesn't exist!"));

        return  mapToDto(country);
    }

    @Override
    public List<CountryDto> GetAllCountries() {
        return null;
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        return null;
    }

    @Override
    public CountryDto updateCountry(int countryId, CountryDto countryDto) {
        return null;
    }

    @Override
    public void deleteCountry(int countryId) {

    }

    @Override
    public List<Owner> getOwnerFromCountry(int countryId) {
        return null;
    }

    private CountryDto mapToDto(Country country) {
        CountryDto countryDto = new CountryDto();

        countryDto.setId(country.getId());
        countryDto.setName(country.getName());

        return countryDto;
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

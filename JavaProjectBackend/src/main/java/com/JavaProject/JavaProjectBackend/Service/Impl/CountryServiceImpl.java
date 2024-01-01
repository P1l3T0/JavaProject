package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import com.JavaProject.JavaProjectBackend.ErrorHandling.CountryNotFoundException;
import com.JavaProject.JavaProjectBackend.ErrorHandling.PokemonNotFoundException;
import com.JavaProject.JavaProjectBackend.Interface.ICountryRepository;
import com.JavaProject.JavaProjectBackend.Models.Country;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import com.JavaProject.JavaProjectBackend.Service.ICountryService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<CountryDto> getAllCountries() {
        List<Country> countries = _countryRepository.findAll();
        List<CountryDto> response = countries.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return response;
    }

    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        Country country = new Country();

        country.setName((countryDto.getName()));

        Country newCountry = _countryRepository.save(country);

        CountryDto countryResponse = new CountryDto();

        countryResponse.setId(newCountry.getId());
        countryResponse.setName(newCountry.getName());

        return mapToDto(country);
    }

    @Override
    public CountryDto updateCountry(int countryId, CountryDto countryDto) {
        Country country = _countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException("Country not found!"));

        country.setName(countryDto.getName());

        Country updatedCountry = _countryRepository.save(country);
        return mapToDto(updatedCountry);
    }

    @Override
    public void deleteCountry(int countryId) {
        Country country = _countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException("Country not found!"));
        _countryRepository.delete(country);
    }

    private CountryDto mapToDto(Country country) {
        CountryDto countryDto = new CountryDto();

        countryDto.setId(country.getId());
        countryDto.setName(country.getName());

        return countryDto;
    }

    private Country mapToEntity(CountryDto countryDto) {
        Country country = new Country();

        country.setId(countryDto.getId());
        country.setName(countryDto.getName());

        return country;
    }
}

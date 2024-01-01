package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import com.JavaProject.JavaProjectBackend.Models.Owner;

import java.util.Collection;
import java.util.List;

public interface ICountryService {
    CountryDto getCountryById(int countryId);
    List<CountryDto> GetAllCountries();
    CountryDto createCountry(CountryDto countryDto);
    CountryDto updateCountry(int countryId, CountryDto countryDto);
    void deleteCountry(int countryId);
    List<Owner> getOwnerFromCountry(int countryId);
}

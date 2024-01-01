package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import java.util.List;

public interface ICountryService {
    List<CountryDto> getAllCountries();
    CountryDto getCountryById(int countryId);
    CountryDto createCountry(CountryDto countryDto);
    CountryDto updateCountry(int countryId, CountryDto countryDto);
    void deleteCountry(int countryId);
}

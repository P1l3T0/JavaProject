package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.DTO.ReviewDto;
import com.JavaProject.JavaProjectBackend.Service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CountryController {
    private ICountryService _countryService;

    @Autowired
    public CountryController(ICountryService countryService) {
        _countryService = countryService;
    }

    @GetMapping("country")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countries = _countryService.getAllCountries();

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("country/{countryId}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable(value = "countryId") int countryId) {
        CountryDto country = _countryService.getCountryById(countryId);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PostMapping("country/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        CountryDto response = _countryService.createCountry(countryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("country/update/{countryId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CountryDto> updatePokemon(@RequestBody CountryDto countryDto, @PathVariable("countryId") int countryId) {
        CountryDto response = _countryService.updateCountry(countryId, countryDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
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

    @GetMapping("/country/{countryId}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable(value = "countryId") int countryId) {
        CountryDto country = _countryService.getCountryById(countryId);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }
}

package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.CountryDto;
import com.JavaProject.JavaProjectBackend.DTO.OwnerDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.Service.IOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class OwnerController {
    private IOwnerService _ownerService;

    public OwnerController(IOwnerService ownerService) {
        _ownerService = ownerService;
    }

    @GetMapping("owner")
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> owners = _ownerService.getAllOwners();

        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("owner/{ownerId}")
    public ResponseEntity<OwnerDto> getById(@PathVariable("ownerId") int ownerId) {
        OwnerDto response = _ownerService.getOwnerById(ownerId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("owner/country/{countryId}")
    public ResponseEntity<List<OwnerDto>> getByCountryId(@PathVariable("countryId") int countryId) {
        List<OwnerDto> response = _ownerService.getOwnerofCountry(countryId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("owner/country/{countryId}/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto, @PathVariable("countryId") int countryId) {
        OwnerDto response = _ownerService.createOwner(ownerDto, countryId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("owner/{ownerId}/update")
    public ResponseEntity<OwnerDto> updateOwner(@RequestBody OwnerDto ownerDto, @PathVariable("ownerId") int ownerId) {
        OwnerDto response = _ownerService.updateOwner(ownerId, ownerDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("owner/{ownerId}/delete")
    public ResponseEntity<String> deleteOwner(@PathVariable("ownerId") int ownerId) {
        _ownerService.deleteOwner(ownerId);

        return new ResponseEntity<>("Owner deleted", HttpStatus.OK);
    }
}

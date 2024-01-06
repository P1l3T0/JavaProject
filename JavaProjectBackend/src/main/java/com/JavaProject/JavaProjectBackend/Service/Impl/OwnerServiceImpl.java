package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.OwnerDto;
import com.JavaProject.JavaProjectBackend.ErrorHandling.CountryNotFoundException;
import com.JavaProject.JavaProjectBackend.ErrorHandling.OwnerNotFoundException;
import com.JavaProject.JavaProjectBackend.ErrorHandling.PokemonNotFoundException;
import com.JavaProject.JavaProjectBackend.Interface.IOwnerRepository;
import com.JavaProject.JavaProjectBackend.Interface.ICountryRepository;
import com.JavaProject.JavaProjectBackend.Models.Country;
import com.JavaProject.JavaProjectBackend.Models.Owner;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import com.JavaProject.JavaProjectBackend.Service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements IOwnerService {
    private IOwnerRepository _ownerRepository;
    private ICountryRepository _countryRepository;
    @Autowired
    public OwnerServiceImpl(IOwnerRepository ownerRepository, ICountryRepository countryRepository) {
        _countryRepository = countryRepository;
        _ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<Owner> owners = _ownerRepository.findAll();
        List<OwnerDto> response = owners.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return response;
    }

    @Override
    public OwnerDto getOwnerById(int ownerId) {
        Owner owner = _ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException("Owner not found!"));
        return  mapToDto(owner);
    }

    @Override
    public OwnerDto createOwner(OwnerDto ownerDto, int countryId) {
        Country country = _countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException("Country not found!"));
        Owner owner = mapToEntity(ownerDto);

        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setGym(ownerDto.getGym());
        owner.setCountry(country);

        Owner newOwner = _ownerRepository.save(owner);

        OwnerDto ownerResponse = new OwnerDto();

        ownerResponse.setId(newOwner.getId());
        ownerResponse.setFirstName(newOwner.getFirstName());
        ownerResponse.setLastName(newOwner.getLastName());
        ownerResponse.setGym(newOwner.getGym());

        return mapToDto(newOwner);
    }

    @Override
    public OwnerDto updateOwner(int ownerId, OwnerDto ownerDto) {
        Owner owner = _ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException("Owner not found!"));

        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setGym(ownerDto.getGym());

        Owner updatedOwner = _ownerRepository.save(owner);
        return mapToDto(updatedOwner);
    }

    @Override
    public void deleteOwner(int ownerId) {
        Owner owner = _ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException("Owner not found!"));
        _ownerRepository.delete(owner);
    }

    @Override
    public List<OwnerDto> getOwnerofCountry(int countryId) {
        List<Owner> owner = _ownerRepository.findOwnerByCountryId(countryId);
        List<OwnerDto> response = owner.stream().map(pk -> mapToDto(pk)).collect(Collectors.toList());

        return response;
    }

    private OwnerDto mapToDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();

        ownerDto.setId(owner.getId());
        ownerDto.setFirstName(owner.getFirstName());
        ownerDto.setLastName(owner.getLastName());
        ownerDto.setGym(owner.getGym());

        return ownerDto;
    }

    private Owner mapToEntity(OwnerDto ownerDto) {
        Owner owner = new Owner();

        owner.setId(ownerDto.getId());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setGym(ownerDto.getGym());

        return owner;
    }
}

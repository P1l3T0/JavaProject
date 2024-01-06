package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.OwnerDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;

import java.util.List;

public interface IOwnerService {
    List<OwnerDto> getAllOwners();
    OwnerDto getOwnerById(int ownerId);
    List<OwnerDto> getOwnerofCountry(int countryId);
    OwnerDto createOwner(OwnerDto ownerDto, int countryId);
    OwnerDto updateOwner(int ownerId, OwnerDto ownerDto);
    void deleteOwner(int ownerId);
}

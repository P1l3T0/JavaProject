package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.OwnerDto;
import java.util.List;

public interface IOwnerService {
    List<OwnerDto> getAllOwners();
    OwnerDto getOwnerById(int ownerId);
    OwnerDto createOwner(OwnerDto ownerDto);
    OwnerDto updateOwner(int ownerId, OwnerDto ownerDto);
    void deleteCountry(int ownerId);
}

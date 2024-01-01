package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.OwnerDto;
import com.JavaProject.JavaProjectBackend.Interface.IOwnerRepository;
import com.JavaProject.JavaProjectBackend.Interface.IPokemonRepository;
import com.JavaProject.JavaProjectBackend.Models.Owner;
import com.JavaProject.JavaProjectBackend.Service.IOwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements IOwnerService {
    private IOwnerRepository _ownerRepositoy;

    public OwnerServiceImpl(IOwnerRepository ownerRepository) {
        _ownerRepositoy = ownerRepository;
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        List<Owner> owners = _ownerRepositoy.findAll();
        List<OwnerDto> response = owners.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return response;
    }

    @Override
    public OwnerDto getOwnerById(int ownerId) {
        return null;
    }

    @Override
    public OwnerDto createOwner(OwnerDto ownerDto) {
        Owner owner = mapToEntity(ownerDto);

        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setGym(ownerDto.getGym());

        Owner newOwner = _ownerRepositoy.save(owner);

        OwnerDto ownerResponse = new OwnerDto();

        ownerResponse.setId(newOwner.getId());
        ownerResponse.setFirstName(newOwner.getFirstName());
        ownerResponse.setLastName(newOwner.getLastName());
        ownerResponse.setGym(newOwner.getGym());

        return mapToDto(newOwner);
    }

    @Override
    public OwnerDto updateOwner(int ownerId, OwnerDto ownerDto) {
        return null;
    }

    @Override
    public void deleteOwner(int ownerId) {

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

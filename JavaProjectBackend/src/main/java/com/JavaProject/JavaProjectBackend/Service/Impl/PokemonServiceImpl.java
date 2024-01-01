package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonResponse;
import com.JavaProject.JavaProjectBackend.ErrorHandling.PokemonNotFoundException;
import com.JavaProject.JavaProjectBackend.Interface.IOwnerRepository;
import com.JavaProject.JavaProjectBackend.Interface.IPokemonRepository;
import com.JavaProject.JavaProjectBackend.Models.Owner;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import com.JavaProject.JavaProjectBackend.Service.IOwnerService;
import com.JavaProject.JavaProjectBackend.Service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements IPokemonService {
    private IPokemonRepository _pokemonRepository;
    private IOwnerRepository _ownerReposity;

    @Autowired
    public PokemonServiceImpl(IPokemonRepository pokemonRepository, IOwnerRepository ownerRepository) {
        _pokemonRepository = pokemonRepository;
        _ownerReposity = ownerRepository;
    }

    @Override
    public PokemonResponse getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Pokemon> pokemons = _pokemonRepository.findAll(pageable);

        List<Pokemon> listOfPokemon = pokemons.getContent();
        List<PokemonDto> content = listOfPokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());

        PokemonResponse pokemonResponse = new PokemonResponse();

        pokemonResponse.setContent(content);
        pokemonResponse.setPageNo(pokemons.getNumber());
        pokemonResponse.setPageSize(pokemons.getSize());
        pokemonResponse.setTotalElements(pokemons.getTotalElements());
        pokemonResponse.setTotalPages(pokemons.getTotalPages());
        pokemonResponse.setLast(pokemons.isLast());

        return pokemonResponse;
    }

    @Override
    public PokemonDto getById(int id) {
        Pokemon pokemon = _pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found!"));
        return  mapToDto(pokemon);
    }

    @Override
    public List<PokemonDto> getPokemonOfOwner(int ownerId) {
        List<Pokemon> pokemon = _pokemonRepository.findPokemonByOwnerId(ownerId);
        List<PokemonDto> response = pokemon.stream().map(pk -> mapToDto(pk)).collect(Collectors.toList());

        return response;
    }
    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto, int ownerId) {
        Owner owner = _ownerReposity.findById(ownerId).orElseThrow(() -> new PokemonNotFoundException("Owner not found!"));

        Pokemon pokemon = new Pokemon();

        pokemon.setName((pokemonDto.getName()));
        pokemon.setType((pokemonDto.getType()));
        pokemon.setOwner(owner);

        Pokemon newPokemon = _pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();

        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());

        return pokemonResponse;
    }
    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto, int id) {
        Pokemon pokemon = _pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found!"));

        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon updatedPokemon = _pokemonRepository.save(pokemon);
        return mapToDto(updatedPokemon);
    }

    @Override
    public void deletePokemon(int id) {
        Pokemon pokemon = _pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found!"));
        _pokemonRepository.delete(pokemon);
    }

    private PokemonDto mapToDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());

        return  pokemonDto;
    }

    private Pokemon mapToEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();

        pokemon.setId(pokemonDto.getId());
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        return  pokemon;
    }
}

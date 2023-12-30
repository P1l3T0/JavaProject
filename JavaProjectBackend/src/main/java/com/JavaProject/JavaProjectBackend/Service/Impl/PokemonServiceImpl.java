package com.JavaProject.JavaProjectBackend.Service.Impl;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.Interface.IPokemonRepository;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import com.JavaProject.JavaProjectBackend.Service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerTemplateAvailabilityProvider;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements IPokemonService {
    private IPokemonRepository _pokemonRepository;

    @Autowired
    public PokemonServiceImpl(IPokemonRepository pokemonRepository) {
        _pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto getById(int id) {
        Pokemon pokemon = _pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found!"));
        return  mapToDto(pokemon);
    }

    @Override
    public List<PokemonDto> getAll() {
        List<Pokemon> pokemon = _pokemonRepository.findAll();
        return pokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();

        pokemon.setName((pokemonDto.getName()));
        pokemon.setType((pokemonDto.getType()));

        Pokemon newPokemon = _pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());

        return pokemonResponse;
    }
    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto, int id) {
        Pokemon pokemon = _pokemonRepository.findById(id).orElseThrow();

        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon updatedPokemon = _pokemonRepository.save(pokemon);
        return mapToDto(updatedPokemon);

    }

    @Override
    public void deletePokemon(int id) {
        Pokemon pokemon = _pokemonRepository.findById(id).orElseThrow();
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

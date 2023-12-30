package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;

import java.util.List;

public interface IPokemonService {
    PokemonDto getById(int id);
    List<PokemonDto> getAll();
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
}

package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;

import java.util.List;

public interface IPokemonService {
    List<PokemonDto> getAll();
    PokemonDto createPokemon(PokemonDto pokemonDto);
}

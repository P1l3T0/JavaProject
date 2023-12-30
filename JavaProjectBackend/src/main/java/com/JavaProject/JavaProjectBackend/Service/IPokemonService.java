package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonResponse;

import java.util.List;

public interface IPokemonService {
    PokemonDto getById(int id);
    PokemonResponse getAll(int pageNo, int pageSize);
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
    void deletePokemon(int id);
}

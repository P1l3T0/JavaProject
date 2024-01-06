package com.JavaProject.JavaProjectBackend.Service;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonResponse;

import java.util.List;

public interface IPokemonService {
    PokemonDto getById(int id);
    List<PokemonDto> getPokemonOfOwner(int ownerId);
    List<PokemonDto> getPokemonOfCategory(int categoryId);
    PokemonResponse getAll(int pageNo, int pageSize);
    PokemonDto createPokemon(PokemonDto pokemonDto, int ownerId, int categoryId);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);
    void deletePokemon(int id);
}

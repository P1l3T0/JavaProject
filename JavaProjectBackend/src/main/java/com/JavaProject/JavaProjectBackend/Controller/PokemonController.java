package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.DTO.PokemonResponse;
import com.JavaProject.JavaProjectBackend.Service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.PolicyNode;
import java.util.*;

@RequestMapping("/api/")
@RestController
public class PokemonController {
    private IPokemonService _pokemonService;

    @Autowired
    public PokemonController(IPokemonService pokemonService) {
        _pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getPokemons(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "0", required = false) int pageSize
    ) {
        PokemonResponse response = _pokemonService.getAll(pageNum, pageSize);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("pokemon/{pokemonId}")
    public ResponseEntity<PokemonDto> getById(@PathVariable("pokemonId") int pokemonId) {
        PokemonDto response = _pokemonService.getById(pokemonId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("pokemon/owner/{ownerId}")
    public ResponseEntity<List<PokemonDto>> getByOwnerId(@PathVariable("ownerId") int ownerId) {
        List<PokemonDto> response = _pokemonService.getPokemonOfOwner(ownerId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("pokemon/owner/{ownerId}/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto, @PathVariable("ownerId") int ownerId) {
        PokemonDto response = _pokemonService.createPokemon(pokemonDto, ownerId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{pokemonId}/update")
    public ResponseEntity<PokemonDto> updatePokemon(@RequestBody PokemonDto pokemonDto, @PathVariable("pokemonId") int pokemonId) {
        PokemonDto response = _pokemonService.updatePokemon(pokemonDto, pokemonId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("pokemon/{pokemonId}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("pokemonId") int pokemonId) {
        _pokemonService.deletePokemon(pokemonId);

        return new ResponseEntity<>("Pokemon deleted", HttpStatus.OK);
    }
}

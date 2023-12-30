package com.JavaProject.JavaProjectBackend.Controller;

import com.JavaProject.JavaProjectBackend.DTO.PokemonDto;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
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
    public ResponseEntity<List<Pokemon>> getPokemons() {
        List<Pokemon> pokemonList = new ArrayList<>();

        pokemonList.add(new Pokemon(1, "Squirtle", "Water"));
        pokemonList.add(new Pokemon(2, "Pikachu", "Electric"));
        pokemonList.add(new Pokemon(3, "Balbazar", "Fire"));

        return ResponseEntity.ok(pokemonList);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon getById(@PathVariable int id) {
        return new Pokemon(id, "Squirtle", "Water");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto) {
        return new ResponseEntity<>(_pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int id) {
        System.out.println(pokemon.getName());

        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int id) {
        System.out.println(id);

        return ResponseEntity.ok("Delete succesfully");
    }
}

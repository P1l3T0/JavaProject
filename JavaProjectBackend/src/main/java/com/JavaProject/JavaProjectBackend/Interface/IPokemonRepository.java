package com.JavaProject.JavaProjectBackend.Interface;

import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> findPokemonByOwnerId(int ownerId);
    List<Pokemon> findPokemonByCategoryId(int categoryId);
}

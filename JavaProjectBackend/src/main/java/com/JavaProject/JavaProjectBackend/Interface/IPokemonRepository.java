package com.JavaProject.JavaProjectBackend.Interface;

import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPokemonRepository extends JpaRepository<Pokemon, Integer> {

}

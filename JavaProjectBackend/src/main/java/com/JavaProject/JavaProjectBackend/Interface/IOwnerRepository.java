package com.JavaProject.JavaProjectBackend.Interface;

import com.JavaProject.JavaProjectBackend.Models.Owner;
import com.JavaProject.JavaProjectBackend.Models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOwnerRepository extends JpaRepository<Owner, Integer> {
    List<Owner> findOwnerByCountryId(int countryId);

}

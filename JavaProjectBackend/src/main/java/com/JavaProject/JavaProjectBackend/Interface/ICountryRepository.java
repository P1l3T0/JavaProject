package com.JavaProject.JavaProjectBackend.Interface;

import com.JavaProject.JavaProjectBackend.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country, Integer> {
}

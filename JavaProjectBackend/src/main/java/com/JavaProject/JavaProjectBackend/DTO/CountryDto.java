package com.JavaProject.JavaProjectBackend.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CountryDto {
    private int id;
    private String name;
}

package com.JavaProject.JavaProjectBackend.Interface;

import com.JavaProject.JavaProjectBackend.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Integer> {

}

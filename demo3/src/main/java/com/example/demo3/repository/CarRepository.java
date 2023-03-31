package com.example.demo3.repository;

import com.example.demo3.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
}

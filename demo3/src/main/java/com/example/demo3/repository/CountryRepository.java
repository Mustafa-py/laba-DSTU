package com.example.demo3.repository;

import com.example.demo3.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long>, CrudRepository<Country, Long> {
}
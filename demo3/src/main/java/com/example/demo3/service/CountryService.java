package com.example.demo3.service;

import com.example.demo3.entity.Car;
import com.example.demo3.entity.Country;
import com.example.demo3.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listAll() {
        return countryRepository.findAll(PageRequest.of(0, 25)).toList();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public Country get(Long id) {
        return countryRepository.findById(id).get();
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    public void deleteCountries(Long [] countryIds) {
        for (Long id : countryIds){
            countryRepository.deleteById(id);
        }
    }
}

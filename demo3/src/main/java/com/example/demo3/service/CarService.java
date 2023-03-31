package com.example.demo3.service;

import com.example.demo3.entity.Car;
import com.example.demo3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository CarBase;

    public List<Car> listAll() {
        return CarBase.findAll();
    }

    public void save(Car car) {
        CarBase.save(car);
    }

    public Car get(Long id) {
        return CarBase.findById(id).get();
    }

    public void delete(Long id){
        CarBase.deleteById(id);
    }
}

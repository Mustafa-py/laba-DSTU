package com.example.demo3.controller;

import org.springframework.ui.Model;
import com.example.demo3.entity.Car;
import com.example.demo3.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/viewCar")
    public String viewIndex(Model model) {
        List<Car> listCar = carService.listAll();
        model.addAttribute("listCars", listCar);
        return "viewCar.html";
    }

    @RequestMapping("/new")
    public String ShowNewCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "addCar.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveCar(Model model, @ModelAttribute("car") Car car) {
        carService.save(car);
        List<Car> listCars = carService.listAll();
        model.addAttribute("listCars", listCars);
        return "/viewCar.html";
    }

    @RequestMapping("/EditCar/{id}")
    public ModelAndView editCar(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editCar");

        Car Car = carService.get(id);
        mav.addObject("car", Car);

        return mav;
    }

    @RequestMapping("/DeleteCar/{id}")
    public String deleteCar(@PathVariable(name = "id") Long id) {
        carService.delete(id);

        return "redirect:/";
    }
}

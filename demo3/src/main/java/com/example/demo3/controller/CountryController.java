package com.example.demo3.controller;

import com.example.demo3.entity.Car;
import com.example.demo3.entity.Country;
import com.example.demo3.service.DeleteCountryForm;
import com.example.demo3.service.CarService;
import com.example.demo3.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CarService carService;

    @RequestMapping("/viewCountry")
    public String viewCountries(Model model) {
        DeleteCountryForm deleteCountryForm = new DeleteCountryForm();
        List<Country> countries = countryService.listAll();
        model.addAttribute("deleteCountryForm", deleteCountryForm);
        model.addAttribute("listCountries", countries);
        return "viewCountry.html";
    }


    @RequestMapping("/newCountry")
    public String newCountry(Model model) {
        Country country = new Country();
        model.addAttribute("country", country);
        return "editCountryForm.html";
    }

    @RequestMapping(value = "/saveCountry", method = RequestMethod.GET)
    public String saveCountry(Model model, @ModelAttribute("country") Country country) {
        DeleteCountryForm deleteCountryForm = new DeleteCountryForm();
        countryService.save(country);
        List<Country> countries = countryService.listAll();
        model.addAttribute("deleteCountryForm", deleteCountryForm);
        model.addAttribute("listCountries", countries);
        return "viewCountry.html";
    }

    @RequestMapping("/EditCountry/{id}")
    public ModelAndView editCountry(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editCountryForm");
        Country country = countryService.get(id);
        List<Car> allCars = carService.listAll();
        mav.addObject("allCars", allCars);
        mav.addObject("country", country);
        return mav;
    }

    @RequestMapping("/DeleteCountry/{id}")
    public String deleteCountry(@PathVariable(name = "id") Long id) {
        countryService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/DeleteCountries")
    public String deleteCountries( @RequestParam("countries") Long [] countryIds, Model model) {
        countryService.deleteCountries(countryIds);
        DeleteCountryForm deleteCountryForm = new DeleteCountryForm();
        List<Country> countries = countryService.listAll();
        model.addAttribute("deleteCountryForm", deleteCountryForm);
        model.addAttribute("listCountries", countries);
        return "viewCountry.html";
    }


}

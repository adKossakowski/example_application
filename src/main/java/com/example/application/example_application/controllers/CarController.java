package com.example.application.example_application.controllers;

import com.example.application.example_application.services.CarService;
import com.example.application.example_application.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public void addCar(@RequestParam ("nazwa")String nazwa,  @RequestParam ("data_zakupu")String data_zakupu, @RequestParam("kolor")String kolor){
        carService.addCar(nazwa, data_zakupu, kolor);
    }

    @GetMapping("/list")
    public List<Car> listAllCars(){
        return carService.listOfCars();
    }

    @GetMapping("/get")
    public Car getCarById(@RequestParam("id")int id){
        return carService.getCarById(id);
    }

    @DeleteMapping("/delete")
    public void deleteCar(@RequestParam("id")int id){
        carService.deleteCar(id);
    }
}

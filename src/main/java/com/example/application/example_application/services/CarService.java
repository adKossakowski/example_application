package com.example.application.example_application.services;


import com.example.application.example_application.dao.CarDao;
import com.example.application.example_application.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CarService {

    @Autowired
    private CarDao carDao;

    public Car getCarById(int id){
        HashMap<Integer, Car> cars = carDao.getCarList();
        return cars.get(id);
    }

    public void addCar(String model, String brand, long mileage){
        HashMap<Integer, Car> cars = carDao.getCarList();
        Integer maxKey = Collections.max(cars.entrySet(), Comparator.comparingInt(p -> p.getValue().getId())).getKey();
        cars.put(maxKey + 1, new Car(maxKey + 1, model, brand, mileage));
        carDao.createNewList(cars);
    }

    public List<Car> listOfCars(){
        HashMap<Integer, Car> cars = carDao.getCarList();
        return new ArrayList<Car> (cars.values());
    }

    public void deleteCar(int id){
        HashMap<Integer, Car> cars = carDao.getCarList();
        cars.remove(id);
        carDao.createNewList(cars);
    }
}

package com.example.application.example_application.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private int id;
    private String model;
    private String brand;
    private long mileage;

}

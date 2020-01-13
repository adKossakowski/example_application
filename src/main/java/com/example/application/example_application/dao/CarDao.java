package com.example.application.example_application.dao;


import com.example.application.example_application.model.Car;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class CarDao {

    private static final String path = "cars.csv";

    public HashMap<Integer, Car> getCarList(){
        HashMap<Integer, Car> cars = new HashMap();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String str = "";
            while((str = br.readLine()) != null){
                String[] line = str.split(",");
                Car car = new Car(Integer.valueOf(line[0]), line[1], line[2], Long.valueOf(line[3]));
                cars.put(car.getId(), car);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return cars;
    }

    public void createNewList(HashMap<Integer, Car> cars){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(Map.Entry<Integer, Car> entry : cars.entrySet()){
                bw.write(entry.getValue().getId() + "," + entry.getValue().getModel() + "," + entry.getValue().getBrand() + "," + entry.getValue().getMileage() + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

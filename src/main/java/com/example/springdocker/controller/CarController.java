package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService service;

    @GetMapping("/foods")
    public List<Car> getFoods() {
        return service.getFoods();
    }

    @PostMapping("/foods")
    public void saveNewFood(@RequestBody Car car) {
        service.saveNewCar(car);
    }

    @GetMapping("/foods/cookable")
    public List<String> getCookableoods() {
        return service.getDrivableCar();
    }
}

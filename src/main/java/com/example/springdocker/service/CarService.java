package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository repository;

    public List<Car> getFoods() {
        return repository.findAll();
    }

    public void saveNewCar(Car car) {
        repository.save(car);
    }

    public List<String> getDrivableCar() {
        // hämtar alla Cars som vi kan köra
        List<Car> drivableCars = repository.findCarByCanIDriveIt(true);

        // returnerar endast Food namnen i en lista
        return drivableCars.stream()
                .map(car -> car.getModel())
                .collect(Collectors.toList());
    }
}

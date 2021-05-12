package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    String id;
    String model;
    String manufacturer;
    String licensePlate;
    LocalDate created;
}

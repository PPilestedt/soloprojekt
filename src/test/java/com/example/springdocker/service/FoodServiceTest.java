package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    @Mock
    FoodRepository mockRepository;

    FoodService foodService;

    List<Food> completeFoodList;
    List<Food> cookableFoodList;

    @BeforeEach
    void init(){

        foodService = new FoodService(mockRepository);

        completeFoodList = Arrays.asList(
                new Food("1","Snail",false,true),
                new Food("2","Mushroom",true,true),
                new Food("3","Cucumber",true,false));

        cookableFoodList = Arrays.asList(
                new Food("1","Snail",false,true),
                new Food("2","Mushroom",true,true));



    }

    @Test
    void getFoods() {
        when(mockRepository.findAll()).thenReturn(completeFoodList);

        List<Food> result = foodService.getFoods();

        assertEquals(completeFoodList,result);
    }

    @Test
    void saveNewFood() {

        Food savedFood = new Food();
        savedFood.setName("fisk");
        savedFood.setDelicious(false);
        savedFood.setCanICookIt(true);

        when(mockRepository.save(any())).thenReturn(savedFood);

        foodService.saveNewFood(savedFood);

        verify(mockRepository).save(any());
    }

    @Test
    void getCookableFoods() {

        List<String> expected = Arrays.asList("Snail","Mushroom");
        when(mockRepository.findFoodByCanICookIt(true)).thenReturn(cookableFoodList);

        List<String> foodStringList = foodService.getCookableFoods();

        assertEquals(expected,foodStringList);

    }
}
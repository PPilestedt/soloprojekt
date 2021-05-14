package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class FoodRepositoryTest {


    // vår klass vi vill testa
    @Autowired
    FoodRepository foodRepository;

    @Test
    void findFoodByCanICookIt() {

        Food food1 = new Food();
        food1.setId("1");
        food1.setName("Fish");
        food1.setDelicious(false);
        food1.setCanICookIt(true);

        Food food2 = new Food();
        food2.setId("2");
        food2.setName("Cake");
        food2.setDelicious(true);
        food2.setCanICookIt(true);

        Food food3 = new Food();
        food3.setId("3");
        food3.setName("Cucumber");
        food3.setDelicious(true);
        food3.setCanICookIt(false);


        List<Food> expected = new ArrayList<>();
        expected.add(food1);
        expected.add(food2);

        foodRepository.save(food1);
        foodRepository.save(food2);
        foodRepository.save(food3);

        List<Food> resultList = foodRepository.findFoodByCanICookIt(true);

        assertEquals(expected,resultList);

    }
}
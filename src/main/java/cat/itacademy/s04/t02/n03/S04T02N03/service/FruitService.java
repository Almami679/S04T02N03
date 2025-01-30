package cat.itacademy.s04.t02.n03.S04T02N03.service;


import cat.itacademy.s04.t02.n03.S04T02N03.service.fruitDto.FruitDTO;
import documents.Fruit;

import java.util.List;

public interface FruitService {
    Fruit addFruit(FruitDTO fruitDTO);
    Fruit updateFruit(Fruit fruitForDTO);
    void deleteFruit(int id);
    Fruit getOneFruit(int id);
    List<Fruit> getAllFruits();
    int getNextId();
}

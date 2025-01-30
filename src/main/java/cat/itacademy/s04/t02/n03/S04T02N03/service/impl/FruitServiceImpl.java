package cat.itacademy.s04.t02.n03.S04T02N03.service.impl;

import cat.itacademy.s04.t02.n03.S04T02N03.exception.custom.DuplicateFruitException;
import cat.itacademy.s04.t02.n03.S04T02N03.exception.custom.NoFruitFoundException;
import cat.itacademy.s04.t02.n03.S04T02N03.repository.FruitRepository;
import cat.itacademy.s04.t02.n03.S04T02N03.service.FruitService;
import cat.itacademy.s04.t02.n03.S04T02N03.service.fruitDto.FruitDTO;
import documents.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(FruitDTO fruitDTO) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitDTO.name());
        fruit.setQuantityKg(fruitDTO.quantityKg());
        fruit.setId(getNextId());
        fruitRepository.findByName(fruit.getName())
                .ifPresent(existingFruit -> {
                    throw new DuplicateFruitException("Entity with the name '" + fruit.getName() + "' already exists.");
                });

        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruitForDTO) {
        Fruit dbFruit = fruitRepository.findById(fruitForDTO.getId())
                .orElseThrow(() -> new NoFruitFoundException("Fruit not found with id " + fruitForDTO.getId()));

        FruitDTO validatedValues = new FruitDTO(fruitForDTO.getName(), fruitForDTO.getQuantityKg());
        dbFruit.setName(validatedValues.name());
        dbFruit.setQuantityKg(validatedValues.quantityKg());

        return fruitRepository.save(dbFruit);
    }

    public void deleteFruit(int id) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new NoFruitFoundException("Fruit not found with id " + id));
        fruitRepository.deleteById(id);
    }

    public Fruit getOneFruit(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new NoFruitFoundException("Fruit not found with id " + id));
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public int getNextId(){
        return getAllFruits().stream()
                .mapToInt(Fruit::getId)
                .max()
                .orElse(0) + 1;
    }

}

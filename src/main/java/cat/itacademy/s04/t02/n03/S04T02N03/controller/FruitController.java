package cat.itacademy.s04.t02.n03.S04T02N03.controller;



import cat.itacademy.s04.t02.n03.S04T02N03.service.fruitDto.FruitDTO;
import cat.itacademy.s04.t02.n03.S04T02N03.service.impl.FruitServiceImpl;
import documents.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fruits")
public class FruitController {

    @Autowired
    private FruitServiceImpl fruitService;

    @GetMapping("/")
    public ResponseEntity<String> getHomePage() {
        return new ResponseEntity<>("Welcome to fruitsAPI\n\n(Based in SQL)", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody FruitDTO fruitDTO) {
        Fruit savedFruit = fruitService.addFruit(fruitDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id) {
        fruitService.deleteFruit(id);
        return new ResponseEntity<>("Entity deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable int id) {
        Fruit fruit = fruitService.getOneFruit(id);
        return ResponseEntity.ok(fruit);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruits();
        return ResponseEntity.ok(fruits);
    }
}

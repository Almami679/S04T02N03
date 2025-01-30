package cat.itacademy.s04.t02.n03.S04T02N03.repository;

import documents.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Integer> {
    Optional<Fruit> findByName(String name);
}

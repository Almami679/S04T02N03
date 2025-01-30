package documents;

import cat.itacademy.s04.t02.n03.S04T02N03.service.FruitService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "fruits")
public class Fruit {

    @Id
    private int id;

    private String name;


    private int quantityKg;

    public Fruit() {
    }

    public Fruit(int id, String name, int quantityKg) {

        this.name = name;
        this.quantityKg = quantityKg;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityKg(int quantityKg) {
        this.quantityKg = quantityKg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantityKg() {
        return quantityKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKg=" + quantityKg +
                '}';
    }

}

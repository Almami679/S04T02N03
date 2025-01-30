package cat.itacademy.s04.t02.n03.S04T02N03.service.fruitDto;

public record FruitDTO (String name, int quantityKg) {

    public FruitDTO {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be null or empty");
        }
        if (quantityKg < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
}

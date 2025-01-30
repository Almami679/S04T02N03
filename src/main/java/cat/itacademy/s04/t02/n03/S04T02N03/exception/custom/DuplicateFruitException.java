package cat.itacademy.s04.t02.n03.S04T02N03.exception.custom;

public class DuplicateFruitException extends RuntimeException {
    public DuplicateFruitException(String message) {
        super(message);
    }
}

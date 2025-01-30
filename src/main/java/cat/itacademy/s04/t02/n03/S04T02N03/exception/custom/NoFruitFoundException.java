package cat.itacademy.s04.t02.n03.S04T02N03.exception.custom;

public class NoFruitFoundException extends RuntimeException {
    public NoFruitFoundException(String message) {
        super(message);
    }
}

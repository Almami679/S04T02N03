package cat.itacademy.s04.t02.n03.S04T02N03.exception;

import cat.itacademy.s04.t02.n03.S04T02N03.exception.custom.DuplicateFruitException;
import cat.itacademy.s04.t02.n03.S04T02N03.exception.custom.NoFruitFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoFruitFoundException.class)
    public ResponseEntity<String> handleNotFoundFruitException(NoFruitFoundException e) {
        log.error("Error due to non-existing entry in database: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateFruitException.class)
    public ResponseEntity<String> handleDuplicateFruitException(DuplicateFruitException e) {
        log.error("Error due to already existing entry in database: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class) //
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Error due to designated value NULL: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception e) {
        log.error("Unexpected error: {}", e.getMessage());
        return new ResponseEntity<>("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

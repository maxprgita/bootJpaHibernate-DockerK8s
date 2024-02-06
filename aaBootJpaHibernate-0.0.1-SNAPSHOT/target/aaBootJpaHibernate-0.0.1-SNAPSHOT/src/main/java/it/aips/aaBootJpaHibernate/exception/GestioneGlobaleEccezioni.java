package it.aips.aaBootJpaHibernate.exception;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
@RestControllerAdvice
public class GestioneGlobaleEccezioni {


    private static final Logger LOGGER = LoggerFactory.getLogger(GestioneGlobaleEccezioni.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        LOGGER.error("Eccezione gestita centralmente:", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno del server");
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        LOGGER.error("Entity non trovata:", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity non trovata");
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        LOGGER.error("Validazione fallita:", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore di validazione");
    }

    // Gestione generica per tutte le altre eccezioni non gestite esplicitamente
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGenericException(Throwable e) {
        LOGGER.error("Eccezione generica gestita centralmente:", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno del server");
    }
}

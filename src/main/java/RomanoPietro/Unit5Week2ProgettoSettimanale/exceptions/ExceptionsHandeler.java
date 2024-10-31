package RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions;


import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.ErrorsResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandeler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //ERRORE 400
    public ErrorsResponseDTO handleBadRequest(BadRequestException ex){
        return new ErrorsResponseDTO(ex.getMessage(), LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class) //ERRORE 404
    public ErrorsResponseDTO handleNotFound(NotFoundException ex){
        return new ErrorsResponseDTO(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class) //ERRORE 500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsResponseDTO handleAll(Exception ex){
        ex.printStackTrace();
        return new ErrorsResponseDTO("Problema lato server. Risolveremo al piú presto!", LocalDateTime.now());
    }
}

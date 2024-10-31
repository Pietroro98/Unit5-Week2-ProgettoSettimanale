package RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id) {
        super("Il record con id: " + id + " non é stato trovato");
    }
}

package RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions;



public class NotFoundException extends RuntimeException{
    public NotFoundException(long id) {
        super("Il record con id: " + id + " non é stato trovato");
    }

}

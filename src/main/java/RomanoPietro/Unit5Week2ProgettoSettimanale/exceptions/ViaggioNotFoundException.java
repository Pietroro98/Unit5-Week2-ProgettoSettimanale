package RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions;

public class ViaggioNotFoundException extends RuntimeException{
    public ViaggioNotFoundException(String id) {
        super("Il record con id: " + id + " non é stato trovato");
    }
}

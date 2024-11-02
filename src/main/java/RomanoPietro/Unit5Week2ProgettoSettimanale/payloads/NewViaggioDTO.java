package RomanoPietro.Unit5Week2ProgettoSettimanale.payloads;

import jakarta.validation.constraints.NotEmpty;

public record NewViaggioDTO(

        @NotEmpty(message = "La destinazione non può essere vuota")
        String destinazione,

        @NotEmpty(message = "La data non può essere vuota")
        String data,

        @NotEmpty(message = "Lo stato non può essere vuoto")
        String stato) {
}

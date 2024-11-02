package RomanoPietro.Unit5Week2ProgettoSettimanale.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewViaggioDTO(

        @NotEmpty(message = "La destinazione non può essere vuota")
        String destinazione,

        @NotEmpty(message = "La data non può essere vuota")
        String data,

        @NotEmpty(message = "Lo stato non può essere vuoto")
        @Size(min = 1, max = 20, message = "Lo stato deve essere compreso tra 1 e 20 caratteri")
        String stato) {
}

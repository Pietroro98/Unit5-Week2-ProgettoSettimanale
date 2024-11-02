package RomanoPietro.Unit5Week2ProgettoSettimanale.payloads;

import java.time.LocalDateTime;

public record NewPrenotazioniDTO(

long dipendenteId,

long viaggioId,

String dataRichiesta,

String preferenze
) {
}

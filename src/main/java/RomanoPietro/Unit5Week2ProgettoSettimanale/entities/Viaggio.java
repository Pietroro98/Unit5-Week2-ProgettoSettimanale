package RomanoPietro.Unit5Week2ProgettoSettimanale.entities;

import RomanoPietro.Unit5Week2ProgettoSettimanale.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "viaggio")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String destinazione;
    private String data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;

    public Viaggio(String destinazione, String data, StatoViaggio statoViaggio) {
        this.destinazione = destinazione;
        this.data = data;
        this.statoViaggio = statoViaggio;
    }
}

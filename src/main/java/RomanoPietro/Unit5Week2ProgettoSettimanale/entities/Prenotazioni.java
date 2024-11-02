package RomanoPietro.Unit5Week2ProgettoSettimanale.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Prenotazioni {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    private Date dataRichiesta;
    private String preferenze;

    public Prenotazioni(Viaggio viaggio, Dipendente dipendente, Date dataRichiesta, String preferenze) {
        this.viaggio = viaggio;
        this.dipendente = dipendente;
        this.dataRichiesta = dataRichiesta;
        this.preferenze = preferenze;

    }
}

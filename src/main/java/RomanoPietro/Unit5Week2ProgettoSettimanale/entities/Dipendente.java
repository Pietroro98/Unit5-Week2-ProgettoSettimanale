package RomanoPietro.Unit5Week2ProgettoSettimanale.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dipendente")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String avatarURL;

    public Dipendente(String username, String nome, String cognome, String email, String avatarURL) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatarURL = avatarURL;
    }
}

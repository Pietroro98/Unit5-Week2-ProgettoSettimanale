package RomanoPietro.Unit5Week2ProgettoSettimanale.repositories;


import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Dipendente;
import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;





public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Long> {

    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, String dataRichiesta);
}

package RomanoPietro.Unit5Week2ProgettoSettimanale.repositories;

import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
    public Viaggio findByDataAndDestinazione(String data, String destinazione);
}

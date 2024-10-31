package RomanoPietro.Unit5Week2ProgettoSettimanale.repositories;

import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Optional<Dipendente> findByEmail(String email);
}
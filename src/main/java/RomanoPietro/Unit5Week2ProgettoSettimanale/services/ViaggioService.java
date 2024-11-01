package RomanoPietro.Unit5Week2ProgettoSettimanale.services;


import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Viaggio;
import RomanoPietro.Unit5Week2ProgettoSettimanale.enums.StatoViaggio;
import RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions.BadRequestException;
import RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions.NotFoundException;
import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.NewViaggioDTO;
import RomanoPietro.Unit5Week2ProgettoSettimanale.repositories.ViaggioRepository;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private Cloudinary cloudinaryUploader;

    //1.======================================================================================================================

    public Viaggio save(NewViaggioDTO body) {
        Viaggio newViaggio = new Viaggio(body.destinazione(),
                body.data(),
                StatoViaggio.valueOf(body.stato()));
        return this.viaggioRepository.save(newViaggio);
    }

    //2.======================================================================================================================

    public Page<Viaggio> findAll(int page, int size, String sortBy) {
        if(size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.viaggioRepository.findAll(pageable);
    }

    //3.======================================================================================================================

    public Viaggio findById(long viaggioId) {
        return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException(viaggioId));
    }

    //4.======================================================================================================================

    public Viaggio findByIdAndUpdate(long viaggioId, NewViaggioDTO body) {
        Viaggio found = this.findById(viaggioId);

        found.setDestinazione(body.destinazione());
        found.setData(body.data());
        found.setStatoViaggio(StatoViaggio.valueOf(body.stato()));

        return this.viaggioRepository.save(found);
    }

    //5.======================================================================================================================

    public void findByIdAndDelete(long viaggioId) {
        Viaggio found = this.findById(viaggioId);
        this.viaggioRepository.delete(found);
    }
}

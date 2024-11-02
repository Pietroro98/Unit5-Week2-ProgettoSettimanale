package RomanoPietro.Unit5Week2ProgettoSettimanale.controllers;


import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Dipendente;
import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Prenotazioni;
import RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions.BadRequestException;
import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.NewDipendenteDTO;
import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.NewPrenotazioniDTO;
import RomanoPietro.Unit5Week2ProgettoSettimanale.services.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/*
*****************************CRUD******************************
*
1. GET http://localhost:3005/prenotazioni
2. POST http://localhost:3005/prenotazioni (+ req.body) --> 201
3. GET http://localhost:3005/prenotazioni/{prenotazioneId}
4. PUT http://localhost:3005/prenotazioni/{prenotazioneId} (+ req.body)
5. DELETE http://localhost:3005/prenotazioni/{prenotazioneId} --> 204
*
* **************************************************************
*/


@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    @Autowired
    private PrenotazioniService prenotazioniService;

    //1. GET http://localhost:3005/prenotazioni
    @GetMapping
    public Page<Prenotazioni> findAll(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy) {
        return this.prenotazioniService.findAll(page, size, sortBy);
    }

    //2. POST http://localhost:3005/prenotazioni (+ req.body) --> 201
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazioni save(@RequestBody @Validated NewPrenotazioniDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult
                    .getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            throw new BadRequestException("ci sono stati errori nel payload!" + message);
        }
        return this.prenotazioniService.save(body);
    }

    //3. GET http://localhost:3005/prenotazioni/{prenotazioneId}

    //4. PUT http://localhost:3005/prenotazioni/{prenotazioneId} (+ req.body)

    //5. DELETE http://localhost:3005/prenotazioni/{prenotazioneId} --> 204

}

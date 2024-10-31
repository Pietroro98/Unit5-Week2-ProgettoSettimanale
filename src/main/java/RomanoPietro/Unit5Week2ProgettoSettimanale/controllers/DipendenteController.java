package RomanoPietro.Unit5Week2ProgettoSettimanale.controllers;

import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Dipendente;
import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Viaggio;
import RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions.BadRequestException;
import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.NewDipendenteDTO;
import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.NewViaggioDTO;
import RomanoPietro.Unit5Week2ProgettoSettimanale.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/*
*****************************CRUD******************************
*
1. GET http://localhost:3001/dipendente
2. POST http://localhost:3001/dipendente (+ req.body) --> 201
3. GET http://localhost:3001/dipendente/{dipendenteId}
4. PUT http://localhost:3001/dipendente/{dipendenteId} (+ req.body)
5. DELETE http://localhost:3001/dipendente/{dipendenteId} --> 204
*
* **************************************************************
*/

@Controller
public class DipendenteController {
    @Autowired
    private DipendenteService dipendenteService;

    //1. GET http://localhost:3001/dipendente
    @GetMapping
    public Page<Dipendente> findAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return this.dipendenteService.findAll(page, size, sortBy);
    }

    //2. POST http://localhost:3001/dipendente (+ req.body) --> 201
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente save(@RequestBody @Validated NewDipendenteDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult
                    .getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            throw new BadRequestException("ci sono stati errori nel payload!" + message);
        }
        return this.dipendenteService.save(body);
    }

    //3. GET http://localhost:3001/dipendente/{dipendenteId}
    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable long dipendenteId) {
        return this.dipendenteService.findById(dipendenteId);
    }

    //4. PUT http://localhost:3001/dipendente/{dipendenteId} (+ req.body)
    @PutMapping("/{dipendenteId}")
    public Dipendente findByIdAndUpdate(@PathVariable long dipendenteId, @RequestBody NewDipendenteDTO body) {
        return this.dipendenteService.findByIdAndUpdate(dipendenteId, body);
    }

    //5. DELETE http://localhost:3001/dipendente/{dipendenteId} --> 204
    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long dipendenteId) {
        this.dipendenteService.findByIdAndDelete(dipendenteId);
    }
}
package RomanoPietro.Unit5Week2ProgettoSettimanale.controllers;

/*
*****************************CRUD******************************
*
1. GET http://localhost:3001/viaggio
2. POST http://localhost:3001/viaggio (+ req.body) --> 201
3. GET http://localhost:3001/viaggio/{viaggioId}
4. PUT http://localhost:3001/viaggio/{viaggioId} (+ req.body)
5. DELETE http://localhost:3001/viaggio/{viaggioId} --> 204
*
* **************************************************************
*/

import RomanoPietro.Unit5Week2ProgettoSettimanale.entities.Viaggio;
import RomanoPietro.Unit5Week2ProgettoSettimanale.exceptions.BadRequestException;
import RomanoPietro.Unit5Week2ProgettoSettimanale.payloads.NewViaggioDTO;
import RomanoPietro.Unit5Week2ProgettoSettimanale.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Collectors;

@Controller
@RequestMapping("/viaggio")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;


    //1. GET http://localhost:3001/viaggio
    @GetMapping
    public Page<Viaggio> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String sortBy) {
        return this.viaggioService.findAll(page, size, sortBy);
    }

    //2. POST http://localhost:3001/viaggio (+ req.body) --> 201
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio save(@RequestBody @Validated NewViaggioDTO body, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            String message = validationResult
                    .getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            throw new BadRequestException("ci sono stati errori nel payload!" + message);
        }
        return this.viaggioService.save(body);
    }

    // 3. GET http://localhost:3001/viaggio/{viaggioId}
    @GetMapping("/{viaggioId}")
    public Viaggio findById(@PathVariable long viaggioId) {
        return this.viaggioService.findById(viaggioId);
    }

    // 4. PUT http://localhost:3001/viaggio/{viaggioId} (+ req.body)
    @PutMapping("/{viaggioId}")
    public Viaggio findByIdAndUpdate(@PathVariable long viaggioId, @RequestBody NewViaggioDTO body) {
        return this.viaggioService.findByIdAndUpdate(viaggioId, body);
    }

    // 5. DELETE http://localhost:3001/viaggio/{viaggioId} --> 204
    @DeleteMapping("/{viaggioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long viaggioId) {
        this.viaggioService.findByIdAndDelete(viaggioId);
    }
}

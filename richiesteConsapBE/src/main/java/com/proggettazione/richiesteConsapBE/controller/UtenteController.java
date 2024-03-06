package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Utente;
import com.proggettazione.richiesteConsapBE.service.impl.UtenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    UtenteServiceImpl utenteServiceImpl;

    @GetMapping
    List<Utente> getAllUtenti(){
        return utenteServiceImpl.getUtenti();
    }

    @PostMapping
    ResponseEntity<Utente> saveUtente(@RequestBody Utente utente){
        return new ResponseEntity<Utente>(utenteServiceImpl.saveUtente(utente), HttpStatus.OK);

    }
}

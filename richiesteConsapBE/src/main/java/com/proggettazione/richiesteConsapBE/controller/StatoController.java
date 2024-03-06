package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Stato;
import com.proggettazione.richiesteConsapBE.service.impl.StatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stato")
public class StatoController {

    @Autowired
    StatoServiceImpl statoServiceImpl;

    @GetMapping
    List<Stato> getAllStati(){
        return statoServiceImpl.getStati();
    }

    @PostMapping
    ResponseEntity<Stato> saveStato(@RequestBody Stato stato){
        return new ResponseEntity<Stato>(statoServiceImpl.saveStato(stato), HttpStatus.OK);
    }
}

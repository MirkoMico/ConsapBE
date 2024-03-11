package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Applicativo;
import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.repository.ApplicativoRepository;
import com.proggettazione.richiesteConsapBE.service.impl.ApplicativoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicativo")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class ApplicativoController {

    @Autowired
    ApplicativoServiceImpl applicativoServiceImpl;

    @PostMapping
    public ResponseEntity<Applicativo> saveApplicativo(@RequestBody Applicativo applicativo){
        return new ResponseEntity<Applicativo>(applicativoServiceImpl.saveApplicativo(applicativo), HttpStatus.OK);
    }
    @GetMapping
    public List<Applicativo> getAllApplicativo(){
        return applicativoServiceImpl.getAllApplicativo();
    }
}

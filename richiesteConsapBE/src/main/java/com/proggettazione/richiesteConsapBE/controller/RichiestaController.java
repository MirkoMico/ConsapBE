package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.Stato;
import com.proggettazione.richiesteConsapBE.service.impl.RichiestaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/richiesta")
public class RichiestaController {

    @Autowired
    RichiestaServiceImpl richiestaServiceImpl;
    @GetMapping
    @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
    public List<Richiesta> getAllRichieste(){
        return richiestaServiceImpl.getRichieste();
    }

    @PostMapping
    public ResponseEntity<Richiesta> saveRichiesta(@RequestBody Richiesta richiesta){
    return  new ResponseEntity<Richiesta>(richiestaServiceImpl.saveRichiesta(richiesta), HttpStatus.OK);
    }
        @PutMapping("/{id}")
        @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
        public ResponseEntity<Richiesta> putRichiesta(@PathVariable int id,
                                                      @RequestBody Richiesta richiesta){
            int statoId = richiesta.getStato().getId();
            System.out.println(statoId + "statoID");
            return new ResponseEntity<Richiesta>(richiestaServiceImpl.putRichiesta(richiesta,id
            ),HttpStatus.OK);
        }
}

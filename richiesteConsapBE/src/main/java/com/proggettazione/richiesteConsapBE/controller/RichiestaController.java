package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
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
  //  @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
    public List<Richiesta> getAllRichieste(){
        return richiestaServiceImpl.getRichieste();
    }

    @PostMapping
    public ResponseEntity<Richiesta> saveRichiesta(@RequestBody Richiesta richiesta){
    return  new ResponseEntity<Richiesta>(richiestaServiceImpl.saveRichiesta(richiesta), HttpStatus.CREATED);
    }
        @PutMapping("/{id}")
       // @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
        public ResponseEntity<Richiesta> putRichiesta(@PathVariable int id,
                                                      @RequestBody Richiesta richiesta){
           // int applicativoId = richiesta.getApplicativo().getApplicativoId();

            return new ResponseEntity<Richiesta>(richiestaServiceImpl.putRichiesta(richiesta,id
            ),HttpStatus.OK);
        }

        @GetMapping("/{id}")
    public ResponseEntity getRichiestaById(@PathVariable int id){
            try {
                return  ResponseEntity.status(HttpStatus.OK).body(richiestaServiceImpl.getRichiestaById(id));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        @DeleteMapping("/{id}")
        public ResponseEntity deleteRichiestaById(@PathVariable int id){
       try{
           return ResponseEntity.status(HttpStatus.OK).body(richiestaServiceImpl.deleteRichiestaById(id));
       }catch (Exception e){
           throw new RuntimeException(e);
       }
        }

        @GetMapping("/numeroTicket/{numeroTicket}")
    public ResponseEntity getRichiesteByNumeroticket(@PathVariable int numeroTicket){
            try {
                return  ResponseEntity.status(HttpStatus.OK).body(richiestaServiceImpl.
                        getRichiestaByNumeroTicket(numeroTicket));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        @GetMapping("/commessa/{commessaOsId}")
    public List<Richiesta> getAllRichiesteByCommessa(@PathVariable int commessaOsId){
       try{
           return richiestaServiceImpl.getAllRichiestaByCommeaaOsId(commessaOsId);
       }catch (Exception e) {
           throw new RuntimeException(e);

       }
        }
        @GetMapping("/applicativo/{applicativoId}")
    public List<Richiesta> getAllRichiestaByApplicativo(@PathVariable int applicativoId){
       try {
           return richiestaServiceImpl.getAllRichiestaByApplicativoId(applicativoId);
       }catch (Exception e) {
           throw new RuntimeException(e);
       }
        }



}

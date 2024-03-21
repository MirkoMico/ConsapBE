package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.repository.RichiestaRepository;
import com.proggettazione.richiesteConsapBE.service.impl.RichiestaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/richiesta")
@Slf4j
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class RichiestaController {

    @Autowired
    RichiestaServiceImpl richiestaServiceImpl;

    @Autowired
    RichiestaRepository richiestaRepository;
  // @GetMapping
  //  @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
   // public List<Richiesta> getAllRichieste(){
    //    return richiestaServiceImpl.getRichieste();
   // }

    @GetMapping
    public Page<Richiesta> getAllRichieste(@RequestParam(required = false)Optional<Integer> page,
                                           @RequestParam(required = false)Optional<Integer> size){
        if(page.isPresent() && size.isPresent()){
            Pageable pageable= PageRequest.of(page.get(),size.get());
            Page<Richiesta> richiestaPage= richiestaRepository.findAll(pageable);
            return richiestaPage;
        }else {
            Page<Richiesta> richiestaPageAltra= Page.empty();
            return richiestaPageAltra;
        }

    }


    //@PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Richiesta> saveRichiesta(@RequestBody Richiesta richiesta){
        System.out.println(richiesta.toString()+ "richiesta");
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

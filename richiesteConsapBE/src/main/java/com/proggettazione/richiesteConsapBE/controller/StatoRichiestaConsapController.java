package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaConsap;
import com.proggettazione.richiesteConsapBE.service.impl.StatoRichiestaConsapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stato")
public class StatoRichiestaConsapController {

    @Autowired
    StatoRichiestaConsapServiceImpl statoServiceImpl;
    /*

    @GetMapping
    List<StatoRichiestaConsap> getAllStati(){
        return statoServiceImpl.getStati();
    }

    @PostMapping
    ResponseEntity<StatoRichiestaConsap> saveStato(@RequestBody StatoRichiestaConsap statoRichiestaConsap){
        return new ResponseEntity<StatoRichiestaConsap>(statoServiceImpl.saveStato(statoRichiestaConsap), HttpStatus.OK);
    }*/
}

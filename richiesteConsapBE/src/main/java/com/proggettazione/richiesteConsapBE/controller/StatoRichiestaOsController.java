package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaConsap;
import com.proggettazione.richiesteConsapBE.model.StatoRichiestaOs;
import com.proggettazione.richiesteConsapBE.service.impl.StatoRichiestaOsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statoRichiestaOs")
public class StatoRichiestaOsController {
    @Autowired
    StatoRichiestaOsServiceImpl statoRichiestaOsServiceImpl;

    @PostMapping
    ResponseEntity<StatoRichiestaOs> saveStatoRichiestaOs(@RequestBody StatoRichiestaOs statoRichiestaOs) {
        return new ResponseEntity<StatoRichiestaOs>(statoRichiestaOsServiceImpl.
                saveStatoRichiestaOs(statoRichiestaOs), HttpStatus.OK);
    }
}

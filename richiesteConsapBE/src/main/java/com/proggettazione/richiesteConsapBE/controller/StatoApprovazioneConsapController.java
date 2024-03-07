package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Applicativo;
import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneConsap;
import com.proggettazione.richiesteConsapBE.service.impl.StatoApprovazioneConsapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statoApprovazioneConsap")
public class StatoApprovazioneConsapController {

    @Autowired
    StatoApprovazioneConsapServiceImpl statoApprovazioneConsapServiceImpl;

    @PostMapping
    public ResponseEntity<StatoApprovazioneConsap> saveStatoApprovazioneConsap
            (@RequestBody StatoApprovazioneConsap statoApprovazioneConsap){
        return new ResponseEntity<StatoApprovazioneConsap>(statoApprovazioneConsapServiceImpl.
                saveStatoApprovazioneConsap(statoApprovazioneConsap), HttpStatus.OK);
    }

}

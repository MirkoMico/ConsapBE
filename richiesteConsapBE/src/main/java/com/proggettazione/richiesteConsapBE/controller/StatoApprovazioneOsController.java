package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOs;
import com.proggettazione.richiesteConsapBE.service.StatoApprovazioneOsService;
import com.proggettazione.richiesteConsapBE.service.impl.StatoApprovazioneOsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statoApprovazioneOs")
public class StatoApprovazioneOsController {

    @Autowired
    StatoApprovazioneOsServiceImpl statoApprovazioneOsServiceImpl;

    @PostMapping
    public ResponseEntity<StatoApprovazioneOs> saveStatoApprovazioneOs(@RequestBody
    StatoApprovazioneOs statoApprovazioneOs ){
        return new ResponseEntity<StatoApprovazioneOs>(statoApprovazioneOsServiceImpl.
                saveStatoApprovazioneOs(statoApprovazioneOs), HttpStatus.OK);

    }
}

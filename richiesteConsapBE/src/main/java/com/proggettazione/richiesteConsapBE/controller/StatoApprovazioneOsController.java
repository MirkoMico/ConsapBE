package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOs;
import com.proggettazione.richiesteConsapBE.service.StatoApprovazioneOsService;
import com.proggettazione.richiesteConsapBE.service.impl.StatoApprovazioneOsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statoApprovazioneOs")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
public class StatoApprovazioneOsController {

    @Autowired
    StatoApprovazioneOsServiceImpl statoApprovazioneOsServiceImpl;

    @PostMapping
    public ResponseEntity<StatoApprovazioneOs> saveStatoApprovazioneOs(@RequestBody
    StatoApprovazioneOs statoApprovazioneOs ){
        return new ResponseEntity<StatoApprovazioneOs>(statoApprovazioneOsServiceImpl.
                saveStatoApprovazioneOs(statoApprovazioneOs), HttpStatus.OK);

    }

    @GetMapping
    public List<StatoApprovazioneOs> getall(){
        return statoApprovazioneOsServiceImpl.getStatoApprovazioneOs();
    }
}

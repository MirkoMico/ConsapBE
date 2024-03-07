package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.CommessaOs;
import com.proggettazione.richiesteConsapBE.service.impl.CommessaOsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commessaOs")
public class CommessaOsController {

    @Autowired
    CommessaOsServiceImpl commessaOsServiceImpl;

    @PostMapping
    public ResponseEntity<CommessaOs> saveCommessaOs(@RequestBody CommessaOs commessaOs){
        return new ResponseEntity<CommessaOs>(commessaOsServiceImpl.saveCommessaOs(commessaOs), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CommessaOs> getAllCommesseOs(){
        return commessaOsServiceImpl.getCommessaOs();
    }

    @PutMapping("/{commessaOsId}")
    public ResponseEntity<CommessaOs> putCommessaOs(@PathVariable int commessaOsId,
                                                    @RequestBody CommessaOs commessaOs){
        return new ResponseEntity<CommessaOs>(commessaOsServiceImpl.putCommessaOs(commessaOsId,commessaOs),
                HttpStatus.OK);
    }

}

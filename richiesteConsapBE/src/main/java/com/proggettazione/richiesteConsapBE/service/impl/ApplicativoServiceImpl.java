package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.Applicativo;
import com.proggettazione.richiesteConsapBE.repository.ApplicativoRepository;
import com.proggettazione.richiesteConsapBE.service.ApplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApplicativoServiceImpl implements ApplicativoService {

    @Autowired
    ApplicativoRepository applicativoRepository;

    @Override
    public Applicativo saveApplicativo(Applicativo applicativo) {
        return applicativoRepository.save(applicativo);
    }

    @Override
    public List<Applicativo> getAllApplicativo() {
        return applicativoRepository.findAll();
    }

    @Override
    public Applicativo getApplicativoById(int applicativoId) {
        return applicativoRepository.findById(applicativoId).orElseThrow(()-> new
         NoSuchElementException("Applicativo non trovato" +" " +applicativoId));
    }

    @Override
    public Applicativo putApplicativo(Applicativo applicativo, int applicativoId) {
         Applicativo newApplicativo= applicativoRepository.findById(applicativoId).orElseThrow(()-> new
                NoSuchElementException("Applicativo non trovato" +" " +applicativoId));
         newApplicativo.setDescApplicativo(applicativo.getDescApplicativo());
         return newApplicativo;
    }


}

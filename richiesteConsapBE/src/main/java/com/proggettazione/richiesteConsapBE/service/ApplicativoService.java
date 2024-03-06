package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Applicativo;

import java.util.List;

public interface ApplicativoService {

    Applicativo saveApplicativo(Applicativo applicativo);
    List<Applicativo> getAllApplicativo();
    Applicativo getApplicativoById(int applicativoId);
    Applicativo putApplicativo (Applicativo applicativo, int applicativoId);
  //  Applicativo deleteApplicativo(int applicativoId);



}

package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.CommessaOs;

import java.util.List;

public interface CommessaOsService {

    CommessaOs saveCommessaOs (CommessaOs commessaOs);
    List<CommessaOs> getCommessaOs();

    CommessaOs putCommessaOs (int idCommessaOs, CommessaOs commessaOs);
    CommessaOs deleteByIDCommessaOs(int idCommessaOs);
}

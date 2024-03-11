package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneConsap;

import java.util.List;

public interface StatoApprovazioneConsapService {

    StatoApprovazioneConsap saveStatoApprovazioneConsap(StatoApprovazioneConsap statoApprovazioneConsap);

    List<StatoApprovazioneConsap> getStatoApprovazioneComsap();
}

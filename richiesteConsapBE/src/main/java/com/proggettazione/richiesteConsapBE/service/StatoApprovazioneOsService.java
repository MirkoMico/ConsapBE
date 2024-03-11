package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOs;

import java.util.List;

public interface StatoApprovazioneOsService {

    StatoApprovazioneOs saveStatoApprovazioneOs(StatoApprovazioneOs statoApprovazioneOs);

    List<StatoApprovazioneOs> getStatoApprovazioneOs();
}

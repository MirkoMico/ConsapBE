package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "StatoApprovazioneConsap")
@Entity
@Data
public class StatoApprovazioneConsap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoApprovazioneConsapId;
    private String descStatoApprovazioneConsap;
}


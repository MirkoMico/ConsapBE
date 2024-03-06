package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class StatoApprovazioneOs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoApprovazioneOsId;
    private String descStatoApprovazioneOsId;

}

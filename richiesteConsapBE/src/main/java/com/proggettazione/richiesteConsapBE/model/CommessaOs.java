package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class CommessaOs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commessaOSId;
    private String descCommesssaOS;
}

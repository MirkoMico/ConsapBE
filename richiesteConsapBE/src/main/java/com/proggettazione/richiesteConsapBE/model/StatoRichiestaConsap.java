package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "StatoRichiestaConsap")
public class StatoRichiestaConsap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoRichiestaConsapId;
    private String descStatoRichiestaConsap;

}

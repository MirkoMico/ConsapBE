package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "StatoRichiestaOs")
public class StatoRichiestaOs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoRichiestaOsId;
    private String descStatoRichiestaOs;

}

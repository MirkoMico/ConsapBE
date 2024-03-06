package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Applicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicativoId;
    private String descApplicativo;
}

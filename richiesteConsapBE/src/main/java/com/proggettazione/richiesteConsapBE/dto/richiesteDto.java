package com.proggettazione.richiesteConsapBE.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class richiesteDto {
    private long idCommessa;
    int statoId;
    private String oggetto;
    private LocalDateTime dataCreazione;
    int statoApprovazione;
    private String note;
    private String campo1;
    private String campo2;
    private String campo3;
    private String campo4;
    private String utenteInserimento;
    private LocalDateTime dataInserimento;
    private String utenteModifica;
    private LocalDateTime dataModifica;
}

package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
public class Richiesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCommessa;
    @ManyToOne
    @JoinColumn(name="id_stato",referencedColumnName = "id")
    private Stato stato;
    private int statoApprovazione;
    private String oggetto;
    private Date dataCreazione;
    private String note;
    private String campo1;
    private String campo2;
    private String campo3;
    private String campo4;
    private String UtenteCreazione;
    private String UtenteModifica;
    private Date dataInserimento;
    private Date dataModifica;
/*
    private Richiesta(int idCommessa, Stato stato, int statoApprovazione, String oggetto,
                      Date dataCreazione, String note, String campo1, String campo2, String campo3,
                      String campo4, String utenteCreazione, String utenteModifica, Date dataInserimento,
                      Date dataModifica){
    }
    */

}



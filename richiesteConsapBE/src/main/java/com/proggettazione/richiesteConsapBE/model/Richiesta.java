package com.proggettazione.richiesteConsapBE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Table
public class Richiesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int numeroTicket ;
    @ManyToOne
    @JoinColumn(name="statoRichiestaConsapId",referencedColumnName = "statoRichiestaConsapId")
    private StatoRichiestaConsap statoRichiestaConsap;
    @ManyToOne
    @JoinColumn(name = "applicativoId",referencedColumnName = "applicativoId")
    private Applicativo applicativo;
    @ManyToOne
    @JoinColumn(name = "statoApprovazioneConsapId",referencedColumnName = "statoApprovazioneConsapId")
    private StatoApprovazioneConsap statoApprovazioneConsap;
    private String oggetto;
 //   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataCreazione;
    @ManyToOne
    @JoinColumn(name = "statoApprovazioneOsId",referencedColumnName = "statoApprovazioneOsId")
    private StatoApprovazioneOs statoApprovazioneOs;
    @ManyToOne
    @JoinColumn(name = "statoRichiestaOsId",referencedColumnName = "statoRichiestaOsId")
    private StatoRichiestaOs statoRichiestaOs;
   // @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dataStimaFine;
    private double importo;
    @ManyToOne
    @JoinColumn(name = "commessaOSId",referencedColumnName = "commessaOSId")
    private CommessaOs commessaOs;


    private String UtenteInserimento;
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



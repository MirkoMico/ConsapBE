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
    private Date dataCreazione;
    @ManyToOne
    @JoinColumn(name = "statoApprovazioneOsId",referencedColumnName = "statoApprovazioneOsId")
    private StatoApprovazioneOs statoApprovazioneOs;
    @ManyToOne
    @JoinColumn(name = "statoRichiestaOsId",referencedColumnName = "statoRichiestaOsId")
    private StatoRichiestaOs statoRichiestaOS;
    private Date dataStimaFinale;
    private double importo;
    @ManyToOne
    @JoinColumn(name = "commessaOSId",referencedColumnName = "commessaOSId")
    private CommessaOs commessaOs;


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



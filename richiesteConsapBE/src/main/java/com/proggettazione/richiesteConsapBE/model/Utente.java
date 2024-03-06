package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="id_Richiesta",referencedColumnName = "id")
    private Richiesta idRichiesta;
    private String username;
    private String password;
    private int idUtenteCreazione;
    private Date dataInserimento;
    private Date dataModifica;
    private int idUtenteModifica;
}


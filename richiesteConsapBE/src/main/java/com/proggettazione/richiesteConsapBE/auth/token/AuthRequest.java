package com.proggettazione.richiesteConsapBE.auth.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
//@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String descrizione;
    private String username;

    public AuthRequest(String descrizione, String username) {
        this.descrizione = descrizione;
        this.username = username;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

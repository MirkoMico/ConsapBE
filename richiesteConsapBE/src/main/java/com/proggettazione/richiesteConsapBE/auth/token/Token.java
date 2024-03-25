package com.proggettazione.richiesteConsapBE.auth.token;

import com.proggettazione.richiesteConsapBE.model.UserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Token {
    public Token(int tokenId, String token, UserEntity user) {
        this.tokenId = tokenId;
        this.token = token;
        this.user = user;
    }

    public Token(String descrizione, UserEntity Username) {
        this.token = descrizione;
        this.user = Username;
    }

    @Id
    @GeneratedValue
    private int tokenId;
    @Column(unique = true)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    public UserEntity user;

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

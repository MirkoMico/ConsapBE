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

}

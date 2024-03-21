package com.proggettazione.richiesteConsapBE.model;

import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import com.proggettazione.richiesteConsapBE.auth.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.profile.Fetch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch= FetchType.EAGER)
    private Collection<RoleEntity> roles =new ArrayList<>();

   //@OneToMany(mappedBy = "user")
   // private List<Token> tokens;
    String accessToken;

    public UserEntity(String username, String accessToken) {
        this.username = username;
        this.accessToken = accessToken;
    }
}

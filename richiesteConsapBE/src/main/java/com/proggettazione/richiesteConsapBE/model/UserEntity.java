package com.proggettazione.richiesteConsapBE.model;

import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.profile.Fetch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch= FetchType.EAGER)
    private Collection<RoleEntity> roles =new ArrayList<>();
}

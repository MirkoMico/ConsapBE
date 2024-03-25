package com.proggettazione.richiesteConsapBE.model;

import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import com.proggettazione.richiesteConsapBE.auth.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.profile.Fetch;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
   // @ManyToMany(fetch= FetchType.EAGER)
   //private Collection<RoleEntity> roles =new ArrayList<>();






    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }



   // public Collection<RoleEntity> getRoles() {
     //   return roles;
   // }

    //public void setRoles(Collection<RoleEntity> roles) {
    //    this.roles = roles;
   // }

 //   public String getAccessToken() {
   //     return accessToken;
   // }

  //  public void setAccessToken(String accessToken) {
    //    this.accessToken = accessToken;
  //  }

    //@OneToMany(mappedBy = "user")
   // private List<Token> tokens;
  //  String accessToken;

  //  public UserEntity(String username, String accessToken) {
   //     this.username = username;
   //     this.accessToken = accessToken;
   // }

    public Object orElseThrow() {
        throw new UnsupportedOperationException();
    }
}

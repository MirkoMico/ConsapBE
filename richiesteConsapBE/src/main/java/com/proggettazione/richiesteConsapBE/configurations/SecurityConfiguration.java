package com.proggettazione.richiesteConsapBE.configurations;

import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import com.proggettazione.richiesteConsapBE.auth.RoleService;
import com.proggettazione.richiesteConsapBE.model.UserEntity;
import com.proggettazione.richiesteConsapBE.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
public class SecurityConfiguration {

   // @Autowired
   // RoleService roleService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {
           // roleService.save(new RoleEntity(null, "ROLE_USER"));
           // roleService.save(new RoleEntity(null, "ROLE_ADMIN"));

          // userService.save(new UserEntity(null, "rossi", "1234", new ArrayList<>()));
          //  userService.save(new UserEntity(null, "bianchi", "1234", new ArrayList<>()));

            //userService.addRoleToUser("rossi", "ROLE_USER");
           // userService.addRoleToUser("bianchi", "ROLE_ADMIN");
           // userService.addRoleToUser("bianchi", "ROLE_USER");
        };
    }
}

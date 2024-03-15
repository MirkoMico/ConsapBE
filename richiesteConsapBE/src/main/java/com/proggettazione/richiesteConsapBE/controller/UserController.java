package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.auth.RoleDTO;
import com.proggettazione.richiesteConsapBE.model.UserEntity;
import com.proggettazione.richiesteConsapBE.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserEntity> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }

    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
        UserEntity userEntity = userService.save(user);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(userEntity.getUsername()).toUriString());
        return ResponseEntity.created(uri).build();
    }


    @PostMapping("/{username}/addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@PathVariable String username, @RequestBody RoleDTO request) {
        UserEntity userEntity = userService.addRoleToUser(username, request.getRoleName());
        return ResponseEntity.ok(userEntity);
    }
}

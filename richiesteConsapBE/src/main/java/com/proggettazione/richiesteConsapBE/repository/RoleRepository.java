package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.auth.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);

   // RoleEntity findById(String roleName);
}

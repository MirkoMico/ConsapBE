package com.proggettazione.richiesteConsapBE.auth;

import com.proggettazione.richiesteConsapBE.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    RoleRepository roleRepository;
    @Override
    public RoleEntity save(RoleEntity roleEntity) {
     //   log.info("Saving role {} to the database", roleEntity.getName());
        return roleRepository.save(roleEntity);

    }
}

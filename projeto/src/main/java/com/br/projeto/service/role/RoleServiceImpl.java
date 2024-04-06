package com.br.projeto.service.role;

import com.br.projeto.entity.role.Role;
import com.br.projeto.entity.role.RoleName;
import com.br.projeto.exception.business.ObjectNotFoundException;
import com.br.projeto.repository.role.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findRoleById(UUID id) {
        return roleRepository
                .findRoleById(id)
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Role for the given id %s not found", id)));
    }

    @Override
    public Set<Role> findRoleByName(RoleName roleName) {
        return roleRepository
                .findAllByRoleName(roleName)
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Role for the given name %s not found", roleName)));
    }
}

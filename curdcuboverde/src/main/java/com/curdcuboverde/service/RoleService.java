package com.curdcuboverde.service;

import com.curdcuboverde.entity.Role;
import com.curdcuboverde.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getRoles(){

        return roleRepository.findAll();
    }
    public Optional<Role> getRol(Long id){

        return roleRepository.findById(id);
    }

    public void saveOrUpdate(Role role){

        roleRepository.save(role);
    }

    public Optional<Role> update(Long id, Role role){
        if (roleRepository.findById(id).isPresent()) {
            Role updateRol = roleRepository.findById(id).get();
            updateRol.setRol(role.getRol());
            roleRepository.save(updateRol);
            return roleRepository.findById(id);
        }
        else {
            return Optional.empty();
        }
    }

    public void delete(Long id){

        roleRepository.deleteById(id);
    }

}

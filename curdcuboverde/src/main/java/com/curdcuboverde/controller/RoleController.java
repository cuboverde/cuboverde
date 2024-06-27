package com.curdcuboverde.controller;

import com.curdcuboverde.entity.Role;
import com.curdcuboverde.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAll(){

        return roleService.getRoles();
    }

    @GetMapping("/{IdRol}")
    public Optional<Role> getBId(@PathVariable("IdRol") Long IdRol){

        return roleService.getRol(IdRol);
    }


    @PostMapping
    public Optional<Role> saveUpdate (@RequestBody Role role){

        roleService.saveOrUpdate(role);
        return roleService.getRol(role.getIdRol());
    }

    @PutMapping("modificar/{id}")
    public Optional<Role> update(@PathVariable("id") Long id, @RequestBody Role role){
        roleService.update(id, role);
        return roleService.getRol(id);
    }

    @DeleteMapping("/{IdRol}")
    public void delete(@PathVariable("IdRol") Long IdRol){

        roleService.delete(IdRol);
    }
}

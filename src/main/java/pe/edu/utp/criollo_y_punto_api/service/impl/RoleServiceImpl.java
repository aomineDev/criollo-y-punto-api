package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.utp.criollo_y_punto_api.repository.RoleRepository;
import pe.edu.utp.criollo_y_punto_api.service.RoleService;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role get(Integer roleid) {
        return roleRepository.findById(roleid).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Integer roleid) {
        roleRepository.deleteById(roleid);
    }
}

package pe.edu.utp.criollo_y_punto_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.utp.criollo_y_punto_api.repository.RoleRepository;
import pe.edu.utp.criollo_y_punto_api.service.RoleService;
import pe.edu.utp.criollo_y_punto_api.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> get(Integer roleid) {
        return roleRepository.findById(roleid);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> update(Integer id, Role role) {
        return roleRepository.findById(id).map(existingRole -> {
            role.setRoleId(id);
            return roleRepository.save(role);
        });
    }

    @Override
    public void delete(Integer roleid) {
        roleRepository.deleteById(roleid);
    }
}

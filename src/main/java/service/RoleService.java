package service;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleByName(String name){
        return roleRepository.findByName(name).orElse(null);
    }

    public Role updateRole(Role role){
        return roleRepository.save(role);
    }

    public String deleteRole(String name){
        Role role = roleRepository.findByName(name).orElse(null);

        if (role == null){
            return "There is no such role";
        } else {
            roleRepository.deleteByName(name);
        }
       return "role deleted success";
    }
}

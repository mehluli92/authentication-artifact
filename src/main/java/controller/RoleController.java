package controller;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @GetMapping("/getRoles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @PutMapping("/updateRole")
    public Role editRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @PutMapping("/deleteRole/{name}")
    public String deleteRole(@PathVariable String name){
        return roleService.deleteRole(name);
    }
}

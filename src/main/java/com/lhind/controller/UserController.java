package com.lhind.controller;

import com.lhind.model.dto.UserDto;
import com.lhind.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> save(@RequestBody UserDto userDto){

        return ResponseEntity.ok(userService.save(userDto));

    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> update(@RequestBody UserDto userDto){

        return ResponseEntity.ok(userService.save(userDto));

    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findByEmail(@RequestParam String username){

        return ResponseEntity.ok(userService.findUserByUsername(username));

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Integer id){

        return ResponseEntity.ok(userService.findById(id));

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addRoleToUser(@PathVariable(name = "id") Integer id, @RequestParam String roleName){

        return ResponseEntity.ok(userService.addRoleToUser(id,roleName));

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){

        return ResponseEntity.ok(userService.delete(id));

    }

    @GetMapping("/all")
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());

    }

}

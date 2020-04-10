package xyz.aymen.example.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.aymen.example.api.UsersApiDelegate;
import xyz.aymen.example.model.NewUser;
import xyz.aymen.example.model.UserDTO;
import xyz.aymen.example.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Service
public class UsersApiImpl implements UsersApiDelegate {

    @Autowired
    private UserService service;

    @Override
    public ResponseEntity<UserDTO> addUser(@Valid NewUser body) {
        return ResponseEntity.ok().body(service.addNewUser(body));
    }

    @Override
    public ResponseEntity<Void> deleteUserById(Long id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok().body(service.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> findUserById(Long id) {
        return ResponseEntity.ok().body(service.findUserById(id));
    }
}

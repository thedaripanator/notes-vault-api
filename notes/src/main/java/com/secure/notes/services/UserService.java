package com.secure.notes.services;

import com.secure.notes.Model.User;
import com.secure.notes.Model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void updateRole(Long id,String role);
    List<User> findAlluser();
    UserDTO getUserById(Long id);
}

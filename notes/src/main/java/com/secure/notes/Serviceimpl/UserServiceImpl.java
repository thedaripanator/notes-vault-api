package com.secure.notes.Serviceimpl;

import com.secure.notes.Model.AppRole;
import com.secure.notes.Model.Role;
import com.secure.notes.Model.User;
import com.secure.notes.Model.UserDTO;
import com.secure.notes.Repository.RoleRepository;
import com.secure.notes.Repository.UserRepository;
import com.secure.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    User user;
    @Autowired
    UserRepository userrepo;
    @Autowired
    RoleRepository rolerepository;

    @Override
    public void updateRole(Long id, String role) {
        User user = userrepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        AppRole appRole = AppRole.valueOf(role);
        Role role1 = rolerepository.findByRoleName(appRole).orElseThrow(() -> new RuntimeException("Role Not Found"));
        user.setRole(role1);
        userrepo.save(user);
    }

    @Override
    public List<User> findAlluser() {
        return userrepo.findAll();
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userrepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return Convert(user);
    }

    private UserDTO Convert(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.isAccountNonLocked(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCredentialsExpiryData(),
                user.getAccountExpiryData(),
                user.getTwoFactorSecret(),
                user.isTwoFactorAuthEnabled(),
                user.getSignUpMethod(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }
}

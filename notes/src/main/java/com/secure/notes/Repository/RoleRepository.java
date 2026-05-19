package com.secure.notes.Repository;

import com.secure.notes.Model.AppRole;
import com.secure.notes.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRole(AppRole appRole);
}

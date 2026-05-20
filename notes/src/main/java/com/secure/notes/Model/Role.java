package com.secure.notes.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.secure.notes.Model.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="roles")
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer roleId;

    @ToString.Exclude
    @Enumerated(EnumType.STRING)
    @Column(length=20,name="role_name")
    private AppRole roleName;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY,cascade = {
            CascadeType.MERGE})
    @JsonBackReference
    @ToString.Exclude
    private Set<User> users=new HashSet();

    public Role(AppRole roleName) {
        this.roleName = roleName;
    }
}

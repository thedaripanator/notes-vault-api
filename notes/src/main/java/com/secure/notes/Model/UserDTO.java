package com.secure.notes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String userName;
    private String email;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private LocalDateTime credentialsExpiryData;
    private LocalDateTime accountExpiryData;


    private String twoFactorSecret;
    private boolean isTwoFactorAuthEnabled;

    private String signUpMethod;
    private Role role;
    private LocalDateTime createdDate;
    private LocalDateTime UpdatedDate;


}

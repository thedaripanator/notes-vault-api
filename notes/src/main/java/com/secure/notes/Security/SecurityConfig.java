package com.secure.notes.Security;

import com.secure.notes.Model.AppRole;
import com.secure.notes.Model.Role;
import com.secure.notes.Repository.RoleRepository;
import com.secure.notes.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import com.secure.notes.Model.User;
import org.springframework.security.web.SecurityFilterChain;
import java.time.LocalDateTime;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,
                      securedEnabled = true,
                       jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests ->
                        requests.anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserRepository userRepository) {
        return args->{
            Role userRole=roleRepository.findByRoleName(AppRole.ROLE_USER)
                    .orElseGet(()->roleRepository.save(new Role(AppRole.ROLE_USER)));
            Role adminRole=roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
                    .orElseGet(()->roleRepository.save(new Role(AppRole.ROLE_ADMIN)));
            if(!userRepository.existsByUsername("user1")){
                User user1=new User("user1","user1@gmail.com","{noop}Password#1");
                user1.setAccountNonLocked(true);
                user1.setAccountNonExpired(true);
                user1.setCredentialsNonExpired(true);
                user1.setEnabled(true);
                user1.setCredentialsExpiryData(LocalDateTime.now().plusYears(2));
                user1.setAccountExpiryData(LocalDateTime.now().plusYears(2));
                user1.setTwoFactorAuthEnabled(false);
                user1.setSignUpMethod("email");
                user1.setRole(userRole);
                userRepository.save(user1);
            }
            if(!userRepository.existsByUsername("admin")){
                User user2=new User("admin","admin@gmail.com","{noop}admin#1");
                user2.setAccountNonLocked(true);
                user2.setAccountNonExpired(true);
                user2.setCredentialsNonExpired(true);
                user2.setEnabled(true);
                user2.setCredentialsExpiryData(LocalDateTime.now().plusYears(2));
                user2.setAccountExpiryData(LocalDateTime.now().plusYears(2));
                user2.setTwoFactorAuthEnabled(false);
                user2.setSignUpMethod("email");
                user2.setRole(adminRole);
                userRepository.save(user2);
            }

        };
    }
}
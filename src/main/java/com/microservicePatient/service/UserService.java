package com.microservicePatient.service;

import com.microservicePatient.model.User;
import com.microservicePatient.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        System.out.println("Tentative de connexion pour: " + identifier); // Debug

        String id = identifier == null ? "" : identifier.trim();
        User user = userRepository.findByEmailIgnoreCase(id)
                .orElseGet(() -> userRepository.findByUsernameIgnoreCase(id)
                        .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + id)));

//        User user = userRepository.findByEmail(identifier)
//                .orElseGet(() -> userRepository.findByUsername(identifier)
//                        .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + identifier)));

        System.out.println("Utilisateur trouvé: " + user.getUsername()); // Debug
        System.out.println("Mot de passe encodé en BDD: " + user.getPassword()); // Debug

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Doit être encodé avec BCrypt
                .authorities("USER") // Ou les rôles de l'utilisateur
                .build();
    }
}

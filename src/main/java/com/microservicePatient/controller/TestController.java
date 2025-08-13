package com.microservicePatient.controller;

import com.microservicePatient.model.User;
import com.microservicePatient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/password/{username}")
    public ResponseEntity<?> testPassword(@PathVariable String username, @RequestParam String rawPassword) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        boolean matches = passwordEncoder.matches(rawPassword, user.getPassword());

        return ResponseEntity.ok(Map.of(
                "username", username,
                "rawPassword", rawPassword,
                "encodedPassword", user.getPassword(),
                "matches", matches,
                "newEncoded", passwordEncoder.encode(rawPassword) // Pour comparaison
        ));
    }
}

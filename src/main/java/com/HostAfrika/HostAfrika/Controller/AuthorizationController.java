package com.HostAfrika.HostAfrika.Controller;

import com.HostAfrika.HostAfrika.DTO.UserDTO.RegisterRequestDTO;
import com.HostAfrika.HostAfrika.Domain.User.User;
import com.HostAfrika.HostAfrika.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthorizationController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequestDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.firstName(), data.lastName(),data.email(), encryptedPassword,
                data.phoneNumber(), data.birthDate(), data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}

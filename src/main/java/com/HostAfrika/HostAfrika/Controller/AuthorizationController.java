package com.HostAfrika.HostAfrika.Controller;

import com.HostAfrika.HostAfrika.DTO.UserDTO.ApiResponseDTO;
import com.HostAfrika.HostAfrika.DTO.UserDTO.LoginRequestDTO;
import com.HostAfrika.HostAfrika.DTO.UserDTO.LoginResponseDTO;
import com.HostAfrika.HostAfrika.DTO.UserDTO.RegisterRequestDTO;
import com.HostAfrika.HostAfrika.DTO.UserDTO.UserResponseDTO;
import com.HostAfrika.HostAfrika.Domain.User.User;
import com.HostAfrika.HostAfrika.Infra.Security.TokenService;
import com.HostAfrika.HostAfrika.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthorizationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody @Valid LoginRequestDTO data){
        try{
            var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(emailPassword);

            var token = this.tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new ApiResponseDTO(true, "Login Successful,",new LoginResponseDTO(token)));
        }catch (RuntimeException exception){
            return ResponseEntity.badRequest().body(new ApiResponseDTO(false, "Credentials do not match"));
        }



    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO> register(@RequestBody @Valid RegisterRequestDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().body(
                new ApiResponseDTO(false, "Email Already exists"));

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.firstName(), data.lastName(),data.email(), encryptedPassword,
                data.phoneNumber(), data.birthDate());

        this.repository.save(newUser);

        return ResponseEntity.ok(new ApiResponseDTO(true, "Registration Successful"));
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getUsers(){
        return repository.findAll().stream().map(UserResponseDTO::new).toList();
    }
}

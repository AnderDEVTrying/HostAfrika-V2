package com.HostAfrika.HostAfrika.DTO.UserDTO;

import com.HostAfrika.HostAfrika.Domain.User.User;
import com.HostAfrika.HostAfrika.Domain.User.UserRole;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public record UserResponseDTO(UUID id, String firstName, String lastName, String email, String password,
                              String phoneNumber, Date birhDate, UserRole role, Timestamp create_Stamp) {
    public UserResponseDTO (User user){
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),user.getPassword(),user.getPhoneNumber(),
                user.getBirthDate(),user.getRole(),user.getCreate_Stamp());
    }
}

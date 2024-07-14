package com.HostAfrika.HostAfrika.DTO.UserDTO;

import com.HostAfrika.HostAfrika.Domain.User.UserRole;

import java.util.Date;

public record RegisterRequestDTO(String firstName, String lastName, String email, String password,
                                 String phoneNumber, Date birthDate, UserRole role) {
}

package com.HostAfrika.HostAfrika.DTO.UserDTO;

import java.util.Date;

public record RegisterRequestDTO(String firstName, String lastName, String email, String password,
                                 String phoneNumber, Date birthDate) {
}

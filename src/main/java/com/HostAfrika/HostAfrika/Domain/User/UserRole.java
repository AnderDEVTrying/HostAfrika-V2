package com.HostAfrika.HostAfrika.Domain.User;

public enum UserRole {
    ADMIN("admin"),
    REGULAR("regular"),
    LANDLORD("landlord");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

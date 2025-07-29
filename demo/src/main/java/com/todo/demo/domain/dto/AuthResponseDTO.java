package com.todo.demo.domain.dto;

import java.util.UUID;

public class AuthResponseDTO
{

    private String token;
    private UUID uuid;
    private String email;

    public AuthResponseDTO(String token, UUID uuid, String email)
    {
        this.token=token;
        this.uuid= uuid;
        this.email=email;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

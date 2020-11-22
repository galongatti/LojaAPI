package br.com.WebService.loja.security.api.jwt;

import lombok.Data;

@Data
public class JwtLoginInput {
    private String username;
    private String password;
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.loja.usuarios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

    private String login;
    private String senha;
    private String token;

    private List<String> roles;

    public static UsuarioDTO create(Usuario usuario) {

        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
        dto.roles = usuario.getRoles().stream().map(r -> r.getNome()).collect(Collectors.toList());
        return dto;
    }

    public static UsuarioDTO create(Usuario user, String token) {
        UsuarioDTO dto = create(user);
        dto.token = token;
        return dto;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }

}

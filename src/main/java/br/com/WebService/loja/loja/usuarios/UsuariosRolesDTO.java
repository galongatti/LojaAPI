
package br.com.WebService.loja.loja.usuarios;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuariosRolesDTO {
    private String login;
    private String nome;
    private String roles;
    
    @Query(value = "SELECT new br.com.WebService.store.usuarios.UsuariosRolesDTO(u.login,r.nome) FROM Usuarios u inner join u.roles r ")
    public String toJson() throws JsonProcessingException{
       ObjectMapper m = new ObjectMapper();
       return m.writeValueAsString(this);
    }
}

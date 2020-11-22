
package br.com.WebService.loja.api.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity(name = "roles")
@Data
public class Roles implements GrantedAuthority{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;    
    
    @Column(name = "nome")
    private String nome;   

    @Override
    public String getAuthority() {
        return this.nome;
    }
    
}

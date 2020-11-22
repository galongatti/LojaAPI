
package br.com.WebService.loja.api.categoria;
import java.awt.geom.GeneralPath;
import lombok.Data;
import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "categoria")
@Data
@NoArgsConstructor
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "descricao")
    private String descricao;
    
}

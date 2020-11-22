package br.com.WebService.loja.api.categoria;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{  
    
}

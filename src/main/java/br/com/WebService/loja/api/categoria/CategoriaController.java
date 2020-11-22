/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.api.categoria;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity get() {
        List<CategoriaDTO> listaCategoria = service.getCategorias();
        return ResponseEntity.ok(listaCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoriaById(@PathVariable("id") long id) {
        
        CategoriaDTO c = service.getCategoriaById(id);
        return ResponseEntity.ok(c);

    }

    @PostMapping("")
    public ResponseEntity post(@RequestBody Categoria categoria) {
        CategoriaDTO c = service.save(categoria);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).build();
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}

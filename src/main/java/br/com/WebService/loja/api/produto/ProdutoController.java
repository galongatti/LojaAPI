package br.com.WebService.loja.api.produto;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity get() {
        List<ProdutoDTO> listaProdutos = service.getProdutos();
        return ResponseEntity.ok(listaProdutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProdutoById(@PathVariable("id") long id) {

        ProdutoDTO produto = service.getProdutoById(id);
        return ResponseEntity.ok(produto);

    }

    @PostMapping("")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity post(@RequestBody Produto produto) {

        ProdutoDTO p = service.save(produto);
        URI location = getUri(p.getId());
        return ResponseEntity.created(location).build();

    }
    
    @PutMapping("")
    public ResponseEntity put(@RequestBody Produto produto) {

        ProdutoDTO p = service.update(produto);
        if (p != null) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.badRequest()
                    .build();
        }

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

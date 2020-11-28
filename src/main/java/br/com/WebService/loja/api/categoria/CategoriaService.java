/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.api.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.WebService.loja.api.categoria.CategoriaRepository;
import br.com.WebService.loja.api.exception.ObjectNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.Assert;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository rep;

    public List<CategoriaDTO> getCategorias() {
        return rep.findAll().stream().map(c -> CategoriaDTO.create(c)).collect(Collectors.toList());
    }

    public CategoriaDTO getCategoriaById(Long id) {
        return rep.findById(id).map(c -> CategoriaDTO.create(c)).orElseThrow(
                () -> new ObjectNotFoundException("Categoria não encontrada"));
    }

    public CategoriaDTO save(Categoria categoria) {
        Assert.notNull(categoria.getId(), "Não deve ser informado o id");
        Assert.notNull(categoria, "Não foi possível inserir a categoria");
        return CategoriaDTO.create(rep.save(categoria));

    }

    public CategoriaDTO update(Categoria categoria) {
        
        Assert.isNull(categoria.getId(),"O id da categoria deve ser informado");
        Assert.isNull(categoria.getDescricao(), "A descrição deve ser informada");
        
        Categoria db = new Categoria();
        db.setId(categoria.getId());
        db.setDescricao(categoria.getDescricao());
        return CategoriaDTO.create(rep.save(db));

    }
    
    public void delete(long id){
        rep.deleteById(id);
    }

}

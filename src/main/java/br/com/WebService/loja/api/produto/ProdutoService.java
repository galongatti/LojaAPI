/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.api.produto;

import br.com.WebService.loja.api.exception.ObjectNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProdutoService {
    
    
    @Autowired
    private ProdutoRepository rep;
    
    public List<ProdutoDTO> getProdutos(){
        return rep.findAll().stream().map(p -> ProdutoDTO.create(p)).collect(Collectors.toList());
    }
    
    public ProdutoDTO getProdutoById(long id){
        return rep.findById(id).map(p -> ProdutoDTO.create(p)).orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado"));
    }
    
    public ProdutoDTO save(Produto produto){
        Assert.notNull(produto.getId(), "Não deve ser informado o id");
        Assert.notNull(produto, "Não foi possível inserir o produto");
        return ProdutoDTO.create(rep.save(produto));
    }
    
    public ProdutoDTO update(Produto produto){
        
        Assert.isNull(produto.getId(), "O id do produto deve ser informado");
        Assert.isNull(produto.getDescricao(), "A descrição do produto deve ser informada");
        Assert.isNull(produto.getPreco(), "O preço do produto deve ser informado");
        
        Produto db = new Produto();
        db.setId(produto.getId());
        db.setDescricao(produto.getDescricao());
        db.setFoto(produto.getFoto());
        db.setCategoria(produto.getCategoria());
        db.setPreco(produto.getPreco());
        
        return ProdutoDTO.create(rep.save(db));
    
    }
    
    public void delete(long id){
        rep.deleteById(id);
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.api.produto;

import br.com.WebService.loja.api.categoria.Categoria;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProdutoDTO {

    private long id;
    private double preco;
    private String descricao;
    private String foto;
    private Categoria categoria;

    public static ProdutoDTO create(Produto p) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(p, ProdutoDTO.class);

    }

}

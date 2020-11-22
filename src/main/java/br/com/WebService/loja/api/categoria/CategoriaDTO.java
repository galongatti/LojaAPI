/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.api.categoria;
import org.modelmapper.ModelMapper;
import lombok.Data;

@Data
public class CategoriaDTO {
    
    private long id;
    private String descricao;
    
    public static CategoriaDTO create(Categoria c){
    
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, CategoriaDTO.class);
    
    }
    
}

package br.com.WebService.loja.loja.usuarios;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;

    public List<UsuarioDTO> getUsuarios() {
        return rep.findAll().stream().map(u -> UsuarioDTO.create(u))
        .collect(Collectors.toList());

    }

}

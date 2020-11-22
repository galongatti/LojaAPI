package br.com.WebService.loja.loja.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.WebService.loja.security.api.jwt.JwtUtil;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity get(){
        List<UsuarioDTO> listaUsuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(listaUsuarios);    
    }
    
    @GetMapping("/userInfo")
    public UserDetails userInfo(@AuthenticationPrincipal Usuario user){
        
        Usuario userDetails = (Usuario) JwtUtil.getUserDetails();
        return userDetails;
    
    }
    
}
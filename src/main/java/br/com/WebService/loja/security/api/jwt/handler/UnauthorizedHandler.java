/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.WebService.loja.security.api.jwt.handler;

import br.com.WebService.loja.security.api.jwt.ServletUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint{

    private static Logger logger = LoggerFactory.getLogger(UnauthorizedHandler.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ae) throws IOException, ServletException {
           logger.warn("UnauthorizedHandler", "exception: " + ae);

        String json = ServletUtil.getJson("error", " Não autorizado");
        ServletUtil.write(response, HttpStatus.FORBIDDEN, json);
    }
    
}

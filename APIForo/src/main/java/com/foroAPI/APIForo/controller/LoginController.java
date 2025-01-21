package com.foroAPI.APIForo.controller;

import com.foroAPI.APIForo.infra.security.DatosJWTToken;
import com.foroAPI.APIForo.infra.security.TokenService;
import com.foroAPI.APIForo.model.usuarios.DatosAutenticacion;
import com.foroAPI.APIForo.model.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody DatosAutenticacion datosAutentication) {
        Authentication token = new UsernamePasswordAuthenticationToken(datosAutentication.email(), datosAutentication.password());
        var usuarioAutenticado = authenticationManager.authenticate(token);
        var JWToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        System.out.println(usuarioAutenticado);
        System.out.println(JWToken);
        return ResponseEntity.ok(new DatosJWTToken(JWToken));
    }
}
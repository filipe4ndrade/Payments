package br.com.payments.controllers;

import br.com.payments.models.dto.AutenticacaoDTO;
import br.com.payments.models.users.User;
import br.com.payments.services.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO autenticacaoDTORequest){
        var autenicationToken = new UsernamePasswordAuthenticationToken(autenticacaoDTORequest.login(), autenticacaoDTORequest.senha());
        var authentication = manager.authenticate(autenicationToken);

        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }


}

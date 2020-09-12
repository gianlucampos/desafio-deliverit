package com.br.testeDeliverIT.controller;

import com.br.testeDeliverIT.model.Conta;
import com.br.testeDeliverIT.service.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gianlucampos
 */
@RestController
@RequestMapping(path = "contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping
    public List<Conta> list() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Conta> post(@RequestBody Conta conta) {
        return ResponseEntity.ok(service.save(conta));
    }

}

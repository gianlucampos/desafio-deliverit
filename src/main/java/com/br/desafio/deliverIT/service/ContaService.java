package com.br.desafio.deliverIT.service;

import com.br.desafio.deliverIT.model.Conta;
import com.br.desafio.deliverIT.repository.ContaRepository;
import com.br.desafio.deliverIT.util.JurosMulta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gianlucampos
 */
@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<Conta> findAll() {
        return repository.findAll();
    }

    public Conta save(Conta conta) {
        return repository.save(new JurosMulta().calcular(conta));
    }

}

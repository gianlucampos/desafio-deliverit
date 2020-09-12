package com.br.testeDeliverIT.service;

import com.br.testeDeliverIT.model.Conta;
import com.br.testeDeliverIT.repository.ContaRepository;
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
        return repository.save(conta);
    }

}

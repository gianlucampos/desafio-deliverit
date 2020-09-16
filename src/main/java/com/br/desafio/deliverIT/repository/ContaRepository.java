package com.br.desafio.deliverIT.repository;

import com.br.desafio.deliverIT.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gianlucampos
 */
@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}

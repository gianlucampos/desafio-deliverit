package com.br.testeDeliverIT.repository;

import com.br.testeDeliverIT.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gianlucampos
 */
@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}

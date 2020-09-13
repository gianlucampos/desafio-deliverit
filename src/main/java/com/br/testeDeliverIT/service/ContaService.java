package com.br.testeDeliverIT.service;

import com.br.testeDeliverIT.model.Conta;
import com.br.testeDeliverIT.repository.ContaRepository;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
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
        return repository.save(calculaDiasAtraso(conta));
    }

    /**
     * Dias de Atraso
     * <br> Até 3 dias |2% multa |Juros por dia 0,1%
     * <br> Superior 3 dias |3% multa |Juros por dia 0,2%
     * <br> Superior 5 dias |5% multa |Juros por dia 0,3%
     */
    private Conta calculaDiasAtraso(Conta conta) {
        Long diasAtraso = ChronoUnit.DAYS.between(conta.getDtVencimento().toInstant(), conta.getDtPagamento().toInstant());
        if (diasAtraso <= 0) {
            conta.setValorCorrigido(conta.getValorOriginal());
            return conta;
        }

        double multa;
        double juros;
        if (diasAtraso <= 3) {
            multa = 0.02;
            juros = 0.001;
        } else if (diasAtraso < 5) {
            multa = 0.05;
            juros = 0.003;
        } else {
            multa = 0.03;
            juros = 0.002;
        }
        double valorMulta = conta.getValorOriginal().doubleValue() * multa;
        double valorJuros = conta.getValorOriginal().doubleValue() * juros;
        double valorCorrigido = valorMulta + (valorJuros * diasAtraso) + conta.getValorOriginal().doubleValue();
        conta.setDiasAtraso(diasAtraso.intValue());
        conta.setValorCorrigido(BigDecimal.valueOf(valorCorrigido));
        return conta;
    }

}

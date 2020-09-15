package com.br.testeDeliverIT.util;

import com.br.testeDeliverIT.model.Conta;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

/**
 * Dias de Atraso
 * <br> Até 3 dias |2% multa |Juros por dia 0,1%
 * <br> Superior 3 dias |3% multa |Juros por dia 0,2%
 * <br> Superior 5 dias |5% multa |Juros por dia 0,3%
 *
 * @author Gianluca
 */
public class JurosMulta {

    public enum Atraso {
        SEM_ATRASO(0, 0),
        ATE_TRES_DIAS(0.02, 0.001),
        ATE_CINCO_DIAS(0.03, 0.002),
        SUPERIOR_CINCO_DIAS(0.05, 0.005);

        private final double valorMulta;
        private final double valorJuros;
        private int dias = 0;

        private Atraso(double valorMulta, double valorJuros) {
            this.valorMulta = valorMulta;
            this.valorJuros = valorJuros;
        }

        private Atraso(double valorMulta, double valorJuros, int dias) {
            this.valorMulta = valorMulta;
            this.valorJuros = valorJuros;
            this.dias = dias;
        }

        public double getValorMulta() {
            return valorMulta;
        }

        public double getValorJuros() {
            return valorJuros;
        }

        public int getDias() {
            return dias;
        }

        public void setDias(int dias) {
            this.dias = dias;
        }

    }

    public Conta calcular(Conta conta) {
        Long diasAtraso = ChronoUnit.DAYS.between(conta.getDtVencimento().toInstant(), conta.getDtPagamento().toInstant());
        Atraso atraso = calculaAtraso(diasAtraso.intValue());
        double valorMulta = conta.getValorOriginal().doubleValue() * atraso.getValorMulta();
        double valorJuros = conta.getValorOriginal().doubleValue() * atraso.getValorJuros();
        double valorCorrigido = valorMulta + (valorJuros * diasAtraso) + conta.getValorOriginal().doubleValue();
        conta.setDiasAtraso(atraso.getDias());
        conta.setValorCorrigido(BigDecimal.valueOf(valorCorrigido));
        return conta;
    }

    private Atraso calculaAtraso(Integer diasAtraso) {
        if (diasAtraso <= 0) {
            return Atraso.SEM_ATRASO;
        }
        Atraso atraso = Atraso.ATE_CINCO_DIAS;
        if (diasAtraso <= 3) {
            atraso = Atraso.ATE_TRES_DIAS;
        } else if (diasAtraso > 5) {
            atraso = Atraso.SUPERIOR_CINCO_DIAS;
        }
        atraso.setDias(diasAtraso);
        return atraso;
    }
}

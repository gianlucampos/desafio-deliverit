package com.br.testeDeliverIT.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gianlucampos
 */
@Entity(name = "Conta")
public class Conta implements Serializable {

    @Id
    @SequenceGenerator(name = "seqconta", sequenceName = "seqconta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqconta")
    private Long id;
    @Column
    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "Data de Vencimento não pode ser nula")
    private Date dtVencimento;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "Data de Pagamento não pode ser nula")
    private Date dtPagamento;
    @Column
    @NotNull(message = "Valor original não pode ser nulo")
    private BigDecimal valorOriginal;
    @Column
    private BigDecimal valorCorrigido;
    @Column
    private Integer diasAtraso = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorCorrigido() {
        return valorCorrigido;
    }

    public void setValorCorrigido(BigDecimal valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

}

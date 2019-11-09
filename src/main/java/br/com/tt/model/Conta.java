package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;

public class Conta {
    private Integer agencia;
    private Integer numero;
    private BigDecimal saldo;
    private List<TipoMovimento> movimentos;

    public Conta(Integer agencia, Integer numero) {
        this.agencia = agencia;
        this.numero = numero;
    }

    public Integer getAgencia() {
        return this.agencia;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getDescription(){
        return new StringBuffer()
                    .append(" Agência: ")
                    .append(this.getAgencia())
                    .append(" - Número da Conta: ")
                    .append(this.getNumero())
                    .toString();
    }
}

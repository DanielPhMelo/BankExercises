package br.com.tt.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Conta {
    private Integer agencia;
    private Integer numero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(agencia, conta.agencia) &&
                Objects.equals(numero, conta.numero) &&
                Objects.equals(saldo, conta.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, saldo);
    }

    private BigDecimal saldo;
    private List<TipoMovimento> movimentos;

    public Conta(Integer agencia, Integer numero) {
        this.agencia = agencia;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
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

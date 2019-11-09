package br.com.tt.model;

public abstract class Correntista {
    private String nome;
    private Conta conta;

    public Correntista(String name){
        this.nome = name;
    }

    public Correntista(String nome, Conta conta){
        this.nome = nome;
        this.conta = conta;
    }
    public String getNome(){
        return this.nome;
    }

    public Conta getConta(){
        return this.conta;
    }

    public String getDescription(){
        return new StringBuffer()
                .append("Nome: ").append(this.getNome())
                .append("Conta: ").append(this.getConta())
                .append(" ] ")
                .toString();
    }
}

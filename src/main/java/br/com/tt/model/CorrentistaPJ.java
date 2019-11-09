package br.com.tt.model;

public class CorrentistaPJ extends Correntista {

    public CorrentistaPJ(String name) {
        super(name);
    }

    public CorrentistaPJ(String nome, Conta conta) {
        super(nome, conta);
    }
}

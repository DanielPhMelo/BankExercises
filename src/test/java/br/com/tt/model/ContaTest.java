package br.com.tt.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ContaTest {

    @Test
    public void shouldReturnConcatString(){
        //Arrange
        Conta conta = new Conta(1, 2);

        //Act
        String description = conta.getDescription();

        //Assert
        assertEquals(" Agência: 1 - Número da Conta: 2", description);
    }

}
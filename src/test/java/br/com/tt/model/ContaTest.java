package br.com.tt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContaTest {

    @Test
    public void shouldReturnConcatString(){
        //Arrange
        Conta conta = new Conta(1, 2);

        //Act
        String description = conta.getDescription();

        //Assert
        Assertions.assertEquals(" Agência: 1 - Número da Conta: 2", description);
    }

}
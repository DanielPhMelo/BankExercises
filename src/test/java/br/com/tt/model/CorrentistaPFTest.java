package br.com.tt.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CorrentistaPFTest {

    @Test
    public void shouldConcatString(){
        //Arrange
        CorrentistaPF correntistaPF = new CorrentistaPF("name",
                                                        new Conta(10,1010),
                                                        "CPF",
                                                        "321654987");
        String expectedConcatString = new StringBuffer()
                                        .append("Tipo de Conta: PF ")
                                        .append("Nome: name ")
                                        .append("Agencia: 10 ")
                                        .append("Conta: 1010 ")
                                        .append("Tipo Documento: CPF ")
                                        .append("Documento: 321654987").toString();
        //Act
        String returnedDescription = correntistaPF.getDescription();

        //Assert
        assertEquals(expectedConcatString, returnedDescription);

    }

}
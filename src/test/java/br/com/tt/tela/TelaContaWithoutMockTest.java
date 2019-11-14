package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.ScannerMockDuble;
import br.com.tt.model.UsuarioUtilMock;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TelaContaWithoutMockTest {

    @Test
    public void shouldCreateAnAccount(){
        //Arrange
        BancoDao bancoDao = new BancoDao();
        TelaConta telaConta = new TelaConta(bancoDao, new ScannerMockDuble(), new UsuarioUtilMock());

        //Act
        telaConta.exibeMenu();

        //Assert
        List<Conta> contas;
        contas = bancoDao.listarContas();
        for (Conta conta: contas){
            System.out.println(conta.getDescription());
        }
    }
}
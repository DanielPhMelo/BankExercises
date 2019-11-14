package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TelaContaWithMockTest {
    @Mock
    private ScannerInterface scanner;
    @Mock
    private BancoDao bancoDao;
    @Mock
    private UsuarioUtil usuarioUtil;
    @Mock
    private Conta conta;

    @Test
    public void exibeMenuCriarContaComSucesso(){
        //Arrange
        Mockito.doReturn("55").when(scanner).nextLine();

        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil).exibeMenuCriarConta();

        //Assert
        Mockito.verify(usuarioUtil).showMessage(" Informe o numero da conta ");
        Mockito.verify(usuarioUtil).showMessage(" Informe a agencia da conta ");
        Mockito.verify(usuarioUtil).showMessage("Conta cadastrada com sucesso!");
        Mockito.verify(scanner, Mockito.times(2)).nextLine();
        Mockito.verify(bancoDao).adicionarConta(new Conta(55,55));
    }

    @Test
    public void exibeMenyListarContaComSucesso(){
        //Arrange
        List<Conta> contas = new ArrayList<Conta>();
        contas.add(new Conta(10, 100));
        contas.add(new Conta(20, 200));

        Mockito.doReturn(contas).when(bancoDao).listarContas();

        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil).exibeMenuListarConta();

        //Assert
        Mockito.verify(usuarioUtil).showMessage("Lista de Contas:");
        Mockito.verify(usuarioUtil).showMessage(" Agência: 10 - Número da Conta: 100");
        Mockito.verify(usuarioUtil).showMessage(" Agência: 20 - Número da Conta: 200");
    }

    @Test
    public void exibeMenuCriarContaOption(){
        //Arrange
        Mockito.doReturn("1").when(scanner).nextLine();

        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil).exibeMenu();

        //Assert
        Mockito.verify(usuarioUtil).showMessage(" Informe o numero da conta ");
    }

    @Test
    public void exibeMenuListarContasOption(){
        //Arrange
        Mockito.doReturn("2").when(scanner).nextLine();

        //Act
        new TelaConta(bancoDao, scanner, usuarioUtil).exibeMenu();

        //Assert
        Mockito.verify(usuarioUtil).showMessage("Lista de Contas:");
    }

}

package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.Scanner;

public class TelaConta implements Tela {
    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaConta(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    @Override
    public void exibeMenu() {
        String exibeMenuText = new StringBuffer()
                                .append("<< Menu Conta \n")
                                .append("Escolha uma opção: \n")
                                .append(" 1 - Criar Conta \n")
                                .append(" 2 - Listar Contas \n").toString();

        usuarioUtil.showMessage(exibeMenuText);

        int option = Integer.parseInt(this.scanner.nextLine());

        if (option == 1) {
            exibeMenuCriarConta();
        } else if (option == 2) {
            exibeMenuListarConta();
        }
    }

    private void exibeMenuCriarConta() {
        usuarioUtil.showMessage(" Informe o numero da conta ");
        Integer accountNumber = Integer.parseInt(this.scanner.nextLine());
        usuarioUtil.showMessage(" Informe a agencia da conta ");
        Integer accountAgency = Integer.parseInt(this.scanner.nextLine());
        bancoDao.adicionarConta(new Conta(accountAgency, accountNumber));
        usuarioUtil.showMessage("Conta cadastrada com sucesso!");
    }

    private void exibeMenuListarConta() {
        usuarioUtil.showMessage("Lista de Contas:");
        for (Conta conta : bancoDao.listarContas()) {
            usuarioUtil.showMessage(conta.getDescription());
        }
    }

    public void exibeMenuPrincipal() {
    }

    public void exibeMenuConta() {
    }
}

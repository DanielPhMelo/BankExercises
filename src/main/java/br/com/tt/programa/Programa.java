package br.com.tt.programa;

import br.com.tt.dao.BancoDao;
import br.com.tt.tela.Tela;
import br.com.tt.tela.TelaConta;
import br.com.tt.tela.TelaCorrentista;
import br.com.tt.util.MasterUsuarioUtil;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.Scanner;

public class Programa {
    private static Tela telaCorrentista;
    private static Tela telaConta;
    private static ScannerInterface scanner;

    public static void main(String[] args) {
        BancoDao bancoDao = new BancoDao();
        scanner = new MasterUsuarioUtil();
        UsuarioUtil usuarioUtil = new MasterUsuarioUtil();
        telaCorrentista = new TelaCorrentista(bancoDao, scanner, usuarioUtil);
        telaConta = new TelaConta(bancoDao, scanner, usuarioUtil);
        while (exibeMenuPrincipal(scanner, usuarioUtil)) {}
    }

    public static boolean exibeMenuPrincipal(ScannerInterface scanner, UsuarioUtil usuarioUtil) {

        String exibeMenuText = new StringBuffer()
                .append("<< Menu Principal >> \n")
                .append("Escolha uma opção: \n")
                .append(" 1 - Correntista \n")
                .append(" 2 - Conta \n")
                .append(" 3 - Movimento \n")
                .append(" 99 - Sair \n")
                .toString();

        usuarioUtil.showMessage(exibeMenuText);

        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            telaCorrentista.exibeMenu();
        } else if (option == 2) {
            telaConta.exibeMenu();
        } else if (option == 99) {
            return false;
        }
        return true;
    }


}

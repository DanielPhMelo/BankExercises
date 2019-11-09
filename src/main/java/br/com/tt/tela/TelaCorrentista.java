package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.model.CorrentistaPF;
import br.com.tt.model.CorrentistaPJ;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;
import java.util.Scanner;

public class TelaCorrentista implements Tela{
    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaCorrentista(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    @Override
    public void exibeMenu() {
        String exibeMenuText = new StringBuffer()
                .append("<< Menu Correntista \n")
                .append("Escolha uma opção: \n")
                .append(" 1 - Criar Correntista \n")
                .append(" 2 - Listar Correntistas \n").toString();

        usuarioUtil.showMessage(exibeMenuText);

        int option = Integer.parseInt(this.scanner.nextLine());

        if (option == 1) {
            exibeMenuCriarCorrentista();
        } else if (option == 2) {
            exibeMenuListarCorrentista();
        }
    }

    private void printAvailableAccounts(List<Conta> contas) {
        usuarioUtil.showMessage("Lista de Contas:");
        Integer position = 0;
        for (Conta conta : contas) {
            position++;
            String stringToPrint = new StringBuffer()
                                    .append("Número Identificador: ")
                                    .append(position.toString())
                                    .append(" - ")
                                    .append(conta.getDescription())
                                    .toString();
            usuarioUtil.showMessage(stringToPrint);
        }
    }

    private void exibeMenuCriarCorrentista() {
        List<Conta> contas = bancoDao.listarContas();

        if (!contas.isEmpty()) {
            usuarioUtil.showMessage(" Informe o nome do correntista ");
            String name = this.scanner.nextLine();

            usuarioUtil.showMessage(" Informe o Tipo de Conta:\n PF\n PJ");
            String tipoCorrentista = this.scanner.nextLine();

            usuarioUtil.showMessage(" Informe o Tipo de Documento: \n");
            String documentType = this.scanner.nextLine();

            usuarioUtil.showMessage(" Informe o Número do Documento: \n");
            String documentNumber = this.scanner.nextLine();

            printAvailableAccounts(contas);
            usuarioUtil.showMessage("Informe o Número Identificador da conta que você deseja vincular:");
            Integer position = Integer.parseInt(this.scanner.nextLine());

            if ("PF".equalsIgnoreCase(tipoCorrentista)){
                bancoDao.adicionarCorrentista(new CorrentistaPF(name, contas.get(position - 1), documentType, documentNumber));
                usuarioUtil.showMessage("Correntista cadastrado com sucesso!");
            }else if ("PJ".equalsIgnoreCase(tipoCorrentista)){
                bancoDao.adicionarCorrentista(new CorrentistaPJ(name, contas.get(position - 1)));
                usuarioUtil.showMessage("Correntista cadastrado com sucesso!");
            }else{
                usuarioUtil.showMessage(" Opcao Inválida\n PF\n PJ");
            }

        } else{
            usuarioUtil.showMessage("\n Nenhuma Conta cadastrada. Você precisa cadastrar uma conta primeiro!\n");
        }



    }

    private void exibeMenuListarCorrentista() {
        List<Correntista> correntistas = bancoDao.listarCorrentistas();
        String stringToPrint = new StringBuffer().append("******************************************************************* \n").toString();
        for (Correntista correntista : correntistas) {
             stringToPrint = stringToPrint.concat(new StringBuffer()
                                                .append("Nome Correntista: ")
                                                .append(correntista.getNome())
                                                .append(" - ")
                                                .append(correntista.getConta().getDescription())
                                                .append("\n").toString());
        }
        stringToPrint = stringToPrint.concat(new StringBuffer().append("*******************************************************************").toString());
        usuarioUtil.showMessage(stringToPrint);
    }

    public void exibeMenuPrincipal() {
    }

    public void exibeMenuCorrentista() {
    }
}

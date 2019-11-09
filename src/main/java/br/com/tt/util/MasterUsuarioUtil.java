package br.com.tt.util;

import javax.swing.*;

public class MasterUsuarioUtil extends UsuarioUtil implements ScannerInterface{
    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);

    }

    @Override
    public String nextLine() {
        return JOptionPane.showInputDialog("Informe um valor");
    }
}

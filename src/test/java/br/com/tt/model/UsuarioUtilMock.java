package br.com.tt.model;

import br.com.tt.util.UsuarioUtil;

public class UsuarioUtilMock extends UsuarioUtil {
    private int numberOfCalls = 0;

    public void showMessage(String message){
        System.out.println(message);
    }

    public int getNumberOfCalls(){
        return this.numberOfCalls++;
    }
}
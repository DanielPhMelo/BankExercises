package br.com.tt.model;

import br.com.tt.util.ScannerInterface;

public class ScannerMockDuble implements ScannerInterface {

    private int numberOfCalls;

    @Override
    public String nextLine() {
        this.numberOfCalls++;
        System.out.println("Mock was called!!!");
        return "1";
    }

    public int getNumberOfCalls(){
        return this.numberOfCalls;
    }

}

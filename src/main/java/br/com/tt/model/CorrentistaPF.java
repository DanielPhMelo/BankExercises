package br.com.tt.model;

public class CorrentistaPF extends Correntista  {

    private String documentType;
    private String document;
    private static final String TIPO_CONTA = "PF";

    public CorrentistaPF(String name, Conta conta,
                         String documentType, String document) {
        super(name, conta);
        this.documentType = documentType;
        this.document = document;
    }


    public String getDescription(){
        return new StringBuffer()
                .append("Tipo de Conta: ").append(TIPO_CONTA)
                .append(" Nome: ").append(super.getNome())
                .append(" Agencia: ").append(this.getConta().getAgencia())
                .append(" Conta: ").append(this.getConta().getNumero())
                .append(" Tipo Documento: ").append(this.documentType)
                .append(" Documento: ").append(this.document)
                .toString();
    }


}

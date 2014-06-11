package entidade.personagens;

import java.util.Date;

public class Cliente extends Usuario {

    private String cidade;
    private String CNPJ;
    private int id;

    public Cliente() {
        super();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        @Override
    public String toString(){
        return "CNPJ: " + this.getCNPJ() +
                "\nID: " + this.getId();
    }
}

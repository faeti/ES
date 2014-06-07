package entidade.personagens;

import entidade.dominio.Localidade;
import java.util.Date;
import java.util.List;

public class Suporte extends Usuario {

    private List<Localidade> localidades;

    public Suporte(String nome, String email, String telefone, Date dataDeNascimento) {
        super(nome, email, telefone, dataDeNascimento);
    }

    public void verificarStatusPonto(int id) {
        
    }

}


package entidade.personagens;

import entidade.dominio.Anuncio;
import java.util.Date;

public class Administrador extends Usuario {

    //private ControleVeiculacao controleVeiculacao;
    //private ControleLocalidade controleLocalidade;
    //private ControlePagamento controlePagamento;
    
    public Administrador(String nome, String email, String telefone, Date dataDeNascimento) {
        super(nome, email, telefone, dataDeNascimento);
    }
    
    public void cadastarAnuncio(Anuncio anuncio) {
        
    }
    
    public void confirmarPagamento(int id) {
        
    }
    
    public void gerarRelatorio() {
        
    }
    
}

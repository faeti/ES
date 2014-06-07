
package entidade.dominio;

import java.util.ArrayList;
import java.util.List;

public class Localidade {

    private final List<Ponto> pontos;
    private final String nome;
    private final int id;
    
    public Localidade(String nome, int id) {
        this.pontos = new ArrayList<>();
        this.nome = nome;
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
    
    public void cadastraPontos(String id, String IP, String MAC) {
        pontos.add(new Ponto(id, IP, MAC));
    }
    
    public List<Ponto> listarPontos() {
        return pontos;
    }
}

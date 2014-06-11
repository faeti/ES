package entidade.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Localidade {

    private final List<Ponto> pontos;
    private final String nome;
    private final int id;

    public Localidade(){
      this.pontos = new ArrayList<>();
      this.nome = null;
      this.id = 0;
    }
    
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
        ordenaPontos();
    }

    public List<Ponto> listarPontos() {
        return pontos;
    }

    public void removerPonto(String id) {
        for (Ponto p : pontos) {
            if (p.getId().equals(id)) {
                pontos.remove(p);
                break;
            }
        }
    }
    
    public Ponto recuperarPonto(String IP, String MAC) {
        Ponto ponto = null;

        for (Ponto p : pontos) {
            if (p.getIP().equals(IP) && p.getMAC().equals(MAC)) {
                ponto = p;
                break;
            }
        }

        return ponto;
    }

    public void atualizarPonto(Ponto ponto) {
        for (Ponto p : pontos) {
            if (p.getId().equals(ponto.getId())) {
                pontos.remove(p);
                pontos.add(ponto);
                break;
            }
        }
        
        ordenaPontos();
    }
    
    private void ordenaPontos() {
        Collections.sort(pontos, new Comparator<Ponto>() {
            @Override
            public int compare(Ponto p1, Ponto p2) {

                return p1.getId().compareTo(p2.getId());
            }
        });
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getNome() +
                "\nID: " + this.getId();
    }
}


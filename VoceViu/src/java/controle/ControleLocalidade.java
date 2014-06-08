package controle;

import entidade.dominio.Localidade;
import java.util.ArrayList;
import java.util.List;

public class ControleLocalidade {

    private final List<Localidade> localidades;

    // singleton para teste sem banco de dados
    private static ControleLocalidade instance = null;
    public static ControleLocalidade getInstance() {
        if (instance == null) {
            instance = new ControleLocalidade();
        }
        return instance;
    }

    public ControleLocalidade() {
        this.localidades = new ArrayList<>();
        mock(); // remover depois
    }

    /*
     Mock de localidades enquanto não há acesso ao bando de dados
     */
    private void mock() {
        Localidade l1 = new Localidade("Shopping Iguatemi", 1);
        l1.cadastraPontos("P1", "192.169.1.1", "e3:ff:68:ac");
        l1.cadastraPontos("P2", "192.169.1.2", "12:ab:70:12");
        l1.cadastraPontos("P3", "192.169.1.3", "08:ee:68:ad");
        l1.cadastraPontos("P4", "192.169.1.4", "9e:ff:7b:07");
        l1.cadastraPontos("P5", "192.169.1.5", "32:ca:cd:66");
        l1.cadastraPontos("P6", "192.169.1.6", "ef:21:12:3f");

        Localidade l2 = new Localidade("Shopping Continente", 2);
        l2.cadastraPontos("P1", "123.69.3.1", "ee:4f:22:da");
        l2.cadastraPontos("P2", "123.69.3.2", "12:ab:70:c4");
        l2.cadastraPontos("P3", "123.69.3.3", "18:3e:54:f1");
        l2.cadastraPontos("P4", "123.69.3.4", "9e:5:7b:f2");

        localidades.add(l1);
        localidades.add(l2);
    }

    public int numeroLocalidades() {
        return localidades.size();
    }

    public List<Localidade> listarLocalidades() {
        return localidades;
    }

    public void cadastrarLocalidade(Localidade localidade) {
        localidades.add(localidade);
    }
    
    public Localidade recuperarLocalidade(String nomeLocalidade) {
        Localidade loc = null;

        for (Localidade l : localidades) {
            if (l.getNome().equals(nomeLocalidade)) {
                loc = l;
                break;
            }
        }

        return loc;
    }
}

package controle;

import entidade.personagens.Usuario;
import java.util.LinkedList;
import java.util.List;

public class ControleUsuario {

    final List<Usuario> usuarios;

    public ControleUsuario() {
        usuarios = new LinkedList<>();
    }

    public void atualizarUsuario(Usuario usuario) {
        // acessa banco de dados e atualiza o usuario
    }

    public void cadastrarUsuario(Usuario usuario) {
        // acessa banco de dados e cadastra o usuario
    }

    public Usuario recuperarUsuario(String login) {
        // acessa banco de dados e recupera usuario pelo login

        return null;
    }

    public void removerUsuario(Usuario usuario) {
        // acessa bando de dados e remove usuario
    }

}

package entidade.personagens;

import java.util.Date;

public class Usuario extends Pessoa {

    protected String login;
    protected String senha;

    public Usuario(String nome, String email, String telefone, Date dataDeNascimento) {
        super(nome, email, telefone, dataDeNascimento);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

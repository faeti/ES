package controle;

import banco.ESDataBase;
import entidade.personagens.Pessoa;
import entidade.personagens.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ESDataBase dataBase = new ESDataBase();
        
        String sql = 
            "Select "+
                    "u.id_usuario, "+
                    "u.nm_usuario, "+
                    "u.ds_senha, "+
                    "u.tp_usuario, "+
                    "p.id_pessoa, "+
                    "p.nm_pessoa, "+
                    "p.ds_email, "+
                    "p.ds_telefone, "+
                    "p.dt_nascimento "+

            "from voceviu.usuario u "+
                    "join voceviu.pessoa p on p.id_pessoa = p.id_pessoa "+

            "where "+
                    "u.nm_usuario = '"+ login +"'";
        
        try {
            
            Usuario usuario = null;
            try (ResultSet rs = dataBase.stmt.executeQuery(sql)) {
                rs.first();
                
                while (rs.next()) {
                    usuario = new Usuario();
                    usuario.setNome(rs.getString("nm_pessoa"));
                    usuario.setEmail(rs.getString("ds_email"));
                    usuario.setTelefone(rs.getString("ds_telefone"));
                    usuario.setDataDeNascimento(rs.getDate("dt_nascimento"));
                    usuario.setLogin(rs.getString("nm_usuario"));
                    usuario.setSenha(rs.getString("ds_senha"));
                }
            }
            
            return usuario;
            
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void removerUsuario(Usuario usuario) {
        // acessa bando de dados e remove usuario
    }

}

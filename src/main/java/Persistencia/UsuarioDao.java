package Persistencia;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection con;
    private ConexaoFactory conFactory;

    public UsuarioDao() {
        this.conFactory = new ConexaoFactory();
        this.con = conFactory.getConnection();
    }

    public void cadastrar(Usuario u) {
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void alterar(Usuario u) {
        String sql = "UPDATE usuario SET nome = ?, login = ?, "
                + "senha = ? WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluir (Usuario u){
        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Usuario> listar (){
        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Usuario novo = new Usuario ();
                novo.setId(rs.getInt("id"));
                novo.setNome("nome");
                novo.setLogin("login");
                novo.setSenha("senha");
                lista.add(novo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public Usuario buscar(int id){
        String sql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement stmt;
        Usuario auxiliar = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                auxiliar = new Usuario();
                auxiliar.setNome(rs.getString("nome"));
                auxiliar.setLogin(rs.getString("login"));
                auxiliar.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return auxiliar;
    }
    
    public void salvar (Usuario u){
        if(buscar(u.getId()) != null){
            alterar(u);
        } else {
            cadastrar(u);
        }
    }

}

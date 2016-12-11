
import Entidades.Usuario;
import Persistencia.UsuarioDao;

public class TesteUsuarioDao {
    
    public static void main (String [] args){
        Usuario usu = new Usuario();
        usu.setNome("Rodrigo Bento Rodrigues");
        usu.setLogin("Tigirina");
        usu.setSenha("3525");
        
        UsuarioDao usuDao = new UsuarioDao();
        usuDao.Cadastrar(usu);
        
        System.out.println("Cadastrado com sucesso !");
    }
    
}

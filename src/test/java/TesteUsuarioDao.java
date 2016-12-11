
import Entidades.Usuario;
import Persistencia.UsuarioDao;

public class TesteUsuarioDao {

    public static void main(String[] args) {
        testExcluir();
    }
    
    public static void testAlterar() {
        Usuario usu = new Usuario();
        usu.setNome("Natan Bento");
        usu.setLogin("Tio Branco");
        usu.setSenha("Thunder");
        usu.setId(5);

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.Alterar(usu);

        System.out.println("Alterado com sucesso !");
    }

    public static void testCadastrar() {
        Usuario usu = new Usuario();
        usu.setNome("Chica D' Silva");
        usu.setLogin("CDS");
        usu.setSenha("SENHA");

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.Cadastrar(usu);

        System.out.println("Cadastrado com sucesso !");
    }
    
    public static void testExcluir() {
        Usuario usu = new Usuario();
        usu.setId(6);

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.Excluir(usu);

        System.out.println("Excluido com sucesso !");
    }

}

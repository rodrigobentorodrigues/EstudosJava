
import Entidades.Usuario;
import Persistencia.UsuarioDao;

public class TesteUsuarioDao {

    public static void main(String[] args) {
        testSalvar();
    }
    
    public static void testAlterar() {
        Usuario usu = new Usuario();
        usu.setId(4);
        usu.setNome("Gon");
        usu.setLogin("Hunter");
        usu.setSenha("Killua");

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.alterar(usu);

        System.out.println("Alterado com sucesso !");
    }

    public static void testCadastrar() {
        Usuario usu = new Usuario();
        usu.setNome("Chica D' Silva");
        usu.setLogin("CDS");
        usu.setSenha("SENHA");

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.cadastrar(usu);

        System.out.println("Cadastrado com sucesso !");
    }
    
    public static void testExcluir() {
        Usuario usu = new Usuario();
        usu.setId(6);

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.excluir(usu);

        System.out.println("Excluido com sucesso !");
    }
    
    public static void testSalvar() {
        Usuario usu = new Usuario();
        usu.setId(9);
        usu.setNome("Myllenne");
        usu.setLogin("Toucinho");
        usu.setSenha("Comida");

        UsuarioDao usuDao = new UsuarioDao();
        usuDao.salvar(usu);

        System.out.println("Salvo com sucesso !");
    }

    
}

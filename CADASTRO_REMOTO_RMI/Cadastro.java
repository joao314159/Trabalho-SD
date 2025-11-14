import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// 1. PRECISA estender a interface java.rmi.Remote
public interface Cadastro extends Remote {

    // 2. Todos os métodos PRECISAM declarar que lançam RemoteException

    /**
     * Cadastra um novo aluno no servidor.
     * 
     */
    void cadastrar(Aluno aluno) throws RemoteException;

    /**
     * Lista todos os alunos cadastrados.
     */
    List<Aluno> listarTodos() throws RemoteException;

    /**
     * Busca um aluno pelo nome.
     */
    Aluno buscarPorNome(String nome) throws RemoteException;
}
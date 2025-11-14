import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

// 1. IMPLEMENTA a interface remota
// 2. ESTENDE UnicastRemoteObject para se tornar um "objeto remoto"
public class ServidorCadastro extends UnicastRemoteObject implements Cadastro {

    // Simulação de um "banco de dados"
    private List<Aluno> listaDeAlunos;

    // Construtor
    protected ServidorCadastro() throws RemoteException {
        super();
        listaDeAlunos = new ArrayList<>();
        System.out.println("Servidor de Cadastro iniciado...");
    }

    // --- Implementação dos métodos da interface ---

    @Override
    public void cadastrar(Aluno aluno) throws RemoteException {
        System.out.println("Cadastrando aluno: " + aluno.getNome());
        listaDeAlunos.add(aluno);
    }

    @Override
    public List<Aluno> listarTodos() throws RemoteException {
        System.out.println("Cliente pediu a lista de alunos...");
        return listaDeAlunos;
    }

    @Override
    public Aluno buscarPorNome(String nome) throws RemoteException {
        System.out.println("Buscando aluno: " + nome);
        for (Aluno aluno : listaDeAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null; // Retorna nulo se não encontrar
    }

    // --- Método Main para iniciar o servidor ---

    public static void main(String[] args) {
        try {
            // 1. Inicia o registro RMI na porta 1099 (padrão)
            LocateRegistry.createRegistry(1099);

            // 2. Cria uma instância do servidor
            ServidorCadastro servidor = new ServidorCadastro();

            // 3. Registra o servidor no RMI Registry com um nome
            // "rmi://localhost/ServicoCadastro"
            Naming.rebind("ServicoCadastro", servidor);

            System.out.println("Servidor pronto para receber chamadas.");

        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
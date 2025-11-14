import java.rmi.Naming;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {
        try {
            // 1. Procura o objeto remoto no RMI Registry (pelo nome)
            Cadastro servico = (Cadastro) Naming.lookup("rmi://localhost/ServicoCadastro");

            // --- 2. Chama os métodos remotos como se fossem locais ---

            System.out.println("Cadastrando alunos...");
            Aluno aluno1 = new Aluno(1, "Ana", "Ciencia da Computacao");
            Aluno aluno2 = new Aluno(2, "Bruno", "Engenharia de Software");

            servico.cadastrar(aluno1); //
            servico.cadastrar(aluno2); //

            System.out.println("--- Alunos Cadastrados ---");
            List<Aluno> alunos = servico.listarTodos(); // [cite: 29]
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }

            System.out.println("\n--- Buscando aluno 'Ana' ---");
            Aluno ana = servico.buscarPorNome("Ana"); // [cite: 29]
            if (ana != null) {
                System.out.println("Encontrado: " + ana);
            } else {
                System.out.println("Aluno nao encontrado.");
            }

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
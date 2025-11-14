import java.io.Serializable;

// 1. PRECISA implementar Serializable para ser enviado pela rede RMI.
public class Aluno implements Serializable {

    // Um ID para a serialização (boa prática)
    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String curso;

    public Aluno(int id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    // Getters (métodos de acesso)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    // Sobrescrevendo o toString() para facilitar a impressão
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Curso: " + curso;
    }
}
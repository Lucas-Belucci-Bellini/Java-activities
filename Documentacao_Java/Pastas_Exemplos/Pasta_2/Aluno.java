public class Aluno {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentarAluno() {
        System.out.println("Aluno: " + nome + " | Idade: " + idade);
    }
}

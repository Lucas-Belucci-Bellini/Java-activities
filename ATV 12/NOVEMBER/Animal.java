public class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ficar vazio.");
        }
        this.nome = nome.trim();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser menor que zero.");
        }
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("O animal está emitindo um som.");
    }

    public void apresentar() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " anos");
    }

    public void apresentar(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public String toString() {
        return "Animal [nome=" + nome + ", idade=" + idade + "]";
    }
}

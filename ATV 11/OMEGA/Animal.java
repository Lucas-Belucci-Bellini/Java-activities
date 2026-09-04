public class Animal {

    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        System.out.println("O animal emitiu um som.");
    }

    public void apresentarDados() {
        System.out.println("Nome: " + nome);
    }
}
public class Forma {

    private String nome;

    public Forma(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double calcularArea() {
        return 0.0;
    }

    public void apresentarDados() {
        System.out.println("Forma: " + nome);
        System.out.println("Area: " + calcularArea());
    }
}

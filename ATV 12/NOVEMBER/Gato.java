public class Gato extends Animal {
    private String cor;

    public Gato(String nome, int idade, String cor) {
        super(nome, idade);
        setCor(cor);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (cor == null || cor.trim().isEmpty()) {
            throw new IllegalArgumentException("Cor não pode ficar vazia.");
        }
        this.cor = cor.trim();
    }

    @Override
    public void emitirSom() {
        System.out.println("O gato está miando.");
    }

    public void dormir() {
        System.out.println("O gato está dormindo.");
    }

    @Override
    public String toString() {
        return "Gato [nome=" + getNome() + ", idade=" + getIdade() + ", cor=" + cor + "]";
    }
}

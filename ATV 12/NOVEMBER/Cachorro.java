public class Cachorro extends Animal {
    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade);
        setRaca(raca);
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if (raca == null || raca.trim().isEmpty()) {
            throw new IllegalArgumentException("Raça não pode ficar vazia.");
        }
        this.raca = raca.trim();
    }

    @Override
    public void emitirSom() {
        System.out.println("O cachorro está latindo.");
    }

    public void brincar() {
        System.out.println("O cachorro está brincando.");
    }

    @Override
    public String toString() {
        return "Cachorro [nome=" + getNome() + ", idade=" + getIdade() + ", raça=" + raca + "]";
    }
}

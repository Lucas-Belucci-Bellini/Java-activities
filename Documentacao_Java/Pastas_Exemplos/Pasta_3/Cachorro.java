public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " latiu: au au!");
    }

    public String getNome() {
        return "Cachorro: " + super.toString();
    }
}

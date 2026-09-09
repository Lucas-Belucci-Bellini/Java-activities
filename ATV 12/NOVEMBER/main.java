public class Main {
    public static void main(String[] args) {
        new Main().executar();
    }

    public void executar() {
        System.out.println("=== PetShop Do Partido Missão ===");
        System.out.println("Dono: Renan Santos");
        System.out.println();

        Cachorro cachorro = new Cachorro("Rex", 3, "Pastor Alemão");
        Gato gato = new Gato("Mimi", 2, "Preta");

        System.out.println(cachorro);
        System.out.println(gato);

        System.out.println("Nome do cachorro: " + cachorro.getNome());
        cachorro.setRaca("Labrador");
        System.out.println("Nova raça do cachorro: " + cachorro.getRaca());

        cachorro.apresentar();
        cachorro.apresentar("Cachorro pronto para brincar!");

        gato.apresentar();
        gato.apresentar("Gato está descansando.");

        cachorro.brincar();
        gato.dormir();

        Animal animal1 = cachorro;
        Animal animal2 = gato;

        animal1.emitirSom();
        animal2.emitirSom();
    }
}

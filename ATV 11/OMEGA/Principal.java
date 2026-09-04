package OMEGA;

public class Principal {

    public static void main(String[] args) {

        Animal cachorro = new Cachorro("Rex");
        Animal gato = new Gato("Mimi");

        cachorro.apresentarDados();
        cachorro.emitirSom();

        System.out.println();

        gato.apresentarDados();
        gato.emitirSom();
    }
}
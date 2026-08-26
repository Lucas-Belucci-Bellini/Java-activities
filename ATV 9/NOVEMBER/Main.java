package NOVEMBER;

public class Main {

    public static void main(String[] args) {

        // Criando um carro.
        // O motor é criado junto com o carro.
        Carro carro = new Carro(
                "Toyota",
                "Corolla",
                2.0,
                "Flex"
        );

        // Apresentando os dados
        carro.apresentarCarro();
    }
}
package ALFA;

public class Main {

    public static void main(String[] args) {

        Gerente gerente = new Gerente(
                "Renan Santos",
                1001,
                5000.00,
                1500.00
        );

        Vendedor vendedor = new Vendedor(
                "Kim Kataguiri",
                1002,
                2500.00,
                20000.00,
                5.0
        );

        Estagiario estagiario = new Estagiario(
                "Gabriel Bertolucc",
                1003,
                1200.00,
                "Universidade Estadual"
        );


        System.out.println("=================================");
        System.out.println("          GERENTE");
        System.out.println("=================================");

        gerente.apresentarDados();

        System.out.printf(
                "Salário final: R$ %.2f%n",
                gerente.calcularSalario()
        );

        gerente.realizarReuniao();


        System.out.println("\n=================================");
        System.out.println("          VENDEDOR");
        System.out.println("=================================");

        vendedor.apresentarDados();

        System.out.printf(
                "Salário final: R$ %.2f%n",
                vendedor.calcularSalario()
        );

        vendedor.registrarVenda();


        System.out.println("\n=================================");
        System.out.println("          ESTAGIÁRIO");
        System.out.println("=================================");

        estagiario.apresentarDados();

        System.out.printf(
                "Salário final: R$ %.2f%n",
                estagiario.calcularSalario()
        );

        estagiario.realizarTreinamento();
    }
}
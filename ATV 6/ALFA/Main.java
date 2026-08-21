package ALFA;

public class Main {

    public static void main(String[] args) {

        try {

            // Criando um Gerente
            Gerente gerente = new Gerente(
                    "Carlos",
                    1001,
                    8000.00,
                    2000.00
            );

            // Criando um Vendedor
            Vendedor vendedor = new Vendedor(
                    "Mariana",
                    1002,
                    2500.00,
                    15000.00,
                    5.0
            );

            // Criando um Estagiário
            Estagiario estagiario = new Estagiario(
                    "Lucas",
                    1003,
                    1200.00,
                    "Universidade Estadual"
            );

            // =========================
            // GERENTE
            // =========================

            System.out.println("=================================");
            System.out.println("          GERENTE");
            System.out.println("=================================");

            gerente.apresentarDados();

            System.out.printf(
                    "Salário final: R$ %.2f%n",
                    gerente.calcularSalario()
            );

            gerente.realizarReuniao();

            // =========================
            // VENDEDOR
            // =========================

            System.out.println();
            System.out.println("=================================");
            System.out.println("          VENDEDOR");
            System.out.println("=================================");

            vendedor.apresentarDados();

            System.out.printf(
                    "Salário final: R$ %.2f%n",
                    vendedor.calcularSalario()
            );

            vendedor.registrarVenda();

            // =========================
            // ESTAGIÁRIO
            // =========================

            System.out.println();
            System.out.println("=================================");
            System.out.println("         ESTAGIÁRIO");
            System.out.println("=================================");

            estagiario.apresentarDados();

            System.out.printf(
                    "Bolsa/Salário final: R$ %.2f%n",
                    estagiario.calcularSalario()
            );

            estagiario.realizarTreinamento();

        } catch (IllegalArgumentException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                    "Ocorreu um erro inesperado: " + e.getMessage()
            );
        }
    }
}
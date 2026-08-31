        package GOLF.main;

        import GOLF.ContaBancaria.ContaBancaria;
        import GOLF.ContaPoupanca.ContaPoupanca;

        public class Principal {

        public static void main(String[] args) {

                ContaBancaria conta = new ContaBancaria(
                        "Lucas",
                        "001234",
                        1500.00,
                        "Banco Omega3"
                );

                ContaPoupanca poupanca = new ContaPoupanca(
                        "Renan Santos",
                        "005678",
                        3000.00,
                        "Banco Omega3",
                        0.5
                );

                conta.apresentarConta();

                System.out.println();

                poupanca.apresentarConta();

                System.out.println();

                System.out.println("=== TESTE DOS GETTERS ===");
                System.out.println("Titular da conta: " + conta.getTitular());
                System.out.println("Saldo da conta: R$ " + conta.getSaldo());

                System.out.println();

                System.out.println("Taxa da poupança: "
                        + poupanca.getTaxaRendimento() + "%");

                System.out.println();

                conta.setSaldo(2000.00);
                poupanca.setTaxaRendimento(0.7);

                System.out.println("=== APÓS ALTERAÇÕES ===");

                System.out.println("Novo saldo da conta: R$ "
                        + conta.getSaldo());

                System.out.println("Nova taxa da poupança: "
                        + poupanca.getTaxaRendimento() + "%");
        }
        }
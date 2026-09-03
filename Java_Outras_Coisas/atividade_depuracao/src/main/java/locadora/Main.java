package locadora;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Carro carro1 = new Carro("ABC1234", "Nissan Skyline R34", 100.0);
        Cliente cliente1 = new Cliente("vladimir putin", 25, 5);
        Cliente cliente3 = new Cliente("Renan Santos", 19, 0);
        Seguro seguro1 = new Seguro("Completo", 25.0);

        Locadora locadora = new Locadora();
        int opcao = -1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (opcao != 0) {
                exibirMenu();
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Valor total (diaria R$100, 5 dias): R$" + locadora.calcularValorTotal(100.0, 5));
                        break;
                    case 2:
                        System.out.println("Valor por dia (total R$500, 5 dias contratados): R$" + locadora.calcularValorPorDia(500, 5));
                        break;
                    case 3:
                        System.out.println("Modelo do carro: " + locadora.obterModeloCarro(carro1));
                        break;
                    case 4:
                        System.out.println("Multa (3 dias de atraso, R$40/dia): R$" + locadora.calcularMultaAtraso(3, 40.0));
                        break;
                    case 5:
                        System.out.println("Primeira letra do modelo: " + locadora.obterPrimeiraLetraModelo(carro1));
                        break;
                    case 6:
                        System.out.println("Valor com 10% de desconto (R$1000): R$" + locadora.calcularValorComDesconto(1000.0, 10.0));
                        break;
                    case 7:
                        System.out.println("Nome do cliente: " + locadora.obterNomeCliente(cliente1));
                        break;
                    case 8:
                        System.out.println("Descricao do carro: " + locadora.obterDescricaoCarro(carro1));
                        break;
                    case 9:
                        System.out.println("Valor com seguro: R$" + locadora.calcularValorComSeguro(carro1, seguro1));
                        break;
                    case 10:
                        System.out.println("Renan Santos (não apto) pode alugar o Nissan Skyline R34? " + locadora.verificarClienteAptoParaCarro(cliente3, carro1));
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n===== ATIVIDADE - REFORCO DE POO =====");
        System.out.println("1 - Calcular valor total (sem objeto)");
        System.out.println("2 - Calcular valor por dia (sem objeto)");
        System.out.println("3 - Obter modelo do carro");
        System.out.println("4 - Calcular multa por atraso (sem objeto)");
        System.out.println("5 - Obter primeira letra do modelo");
        System.out.println("6 - Calcular valor com desconto (sem objeto)");
        System.out.println("7 - Obter nome do cliente");
        System.out.println("8 - Obter descricao do carro");
        System.out.println("9 - Calcular valor com seguro (dois objetos)");
        System.out.println("10 - Verificar se cliente apto pode alugar o carro (dois objetos)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }
}

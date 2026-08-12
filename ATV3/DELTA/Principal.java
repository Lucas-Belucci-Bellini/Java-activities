package DELTA;

public class Principal {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("Carlos Silva", "Gerente", 6500.00);
        Funcionario funcionario2 = new Funcionario("Ana Souza", "Analista", 4200.50);

        System.out.println(funcionario1);
        System.out.println(funcionario2);
    }
}

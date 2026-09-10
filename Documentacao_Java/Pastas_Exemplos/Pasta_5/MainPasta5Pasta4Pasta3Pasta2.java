public class MainPasta5 {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("Ana", 2500.0);
        Gerente g = new Gerente("Carlos", 2500.0);

        System.out.println("Salário funcionário: R$ " + f.calcularSalario());
        System.out.println("Salário gerente: R$ " + g.calcularSalario());
    }
}

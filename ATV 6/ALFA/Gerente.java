package ALFA;

public class Gerente extends Funcionario {

    private double valorBonus;

    public Gerente(String nome, int matricula, double salarioBase, double valorBonus) {

        super(nome, matricula, salarioBase);

        if (valorBonus < 0) {
            throw new IllegalArgumentException("O valor do bônus não pode ser negativo.");
        }

        this.valorBonus = valorBonus;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {

        if (valorBonus < 0) {
            throw new IllegalArgumentException("O valor do bônus não pode ser negativo.");
        }

        this.valorBonus = valorBonus;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + valorBonus;
    }

    public void realizarReuniao() {
        System.out.println("O gerente está realizando uma reunião.");
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();
        System.out.printf("Bônus: R$ %.2f%n", valorBonus);
    }
}
package DELTA;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + ", Cargo: " + cargo
                + ", Salário: R$ " + String.format("%.2f", salario);
    }
}

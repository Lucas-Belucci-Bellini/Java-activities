package ALFA;

public class Funcionario {

    private String nome;
    private int matricula;
    private double salarioBase;

    public Funcionario(String nome, int matricula, double salarioBase) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        if (matricula <= 0) {
            throw new IllegalArgumentException("A matrícula deve ser maior que zero.");
        }

        if (salarioBase <= 0) {
            throw new IllegalArgumentException("O salário-base deve ser maior que zero.");
        }

        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }

    // Getters

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    // Setters

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        this.nome = nome;
    }

    public void setMatricula(int matricula) {

        if (matricula <= 0) {
            throw new IllegalArgumentException("A matrícula deve ser maior que zero.");
        }

        this.matricula = matricula;
    }

    public void setSalarioBase(double salarioBase) {

        if (salarioBase <= 0) {
            throw new IllegalArgumentException("O salário-base deve ser maior que zero.");
        }

        this.salarioBase = salarioBase;
    }

    // Método que poderá ser sobrescrito

    public double calcularSalario() {
        return salarioBase;
    }

    public void apresentarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.printf("Salário-base: R$ %.2f%n", salarioBase);
    }
}
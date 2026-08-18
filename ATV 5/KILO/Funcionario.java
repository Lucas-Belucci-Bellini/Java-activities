package KILO;

public class Funcionario extends Pessoa {

    private double salario;
    private String setor;
    private String matricula;

    public Funcionario(
            String nome,
            int idade,
            String cpf,
            double salario,
            String setor,
            String matricula) {

        super(nome, idade, cpf);

        this.salario = salario;
        this.setor = setor;
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println("Salário: " + salario);
        System.out.println("Setor: " + setor);
        System.out.println("Matrícula: " + matricula);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", salario=" + salario +
                ", setor='" + setor + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
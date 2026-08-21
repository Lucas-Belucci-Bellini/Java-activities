package KILO;

public class Coordenador extends Funcionario {

    private String curso;
    private int quantidadeTurmas;

    public Coordenador(
            String nome,
            int idade,
            String cpf,
            double salario,
            String setor,
            String matricula,
            String curso,
            int quantidadeTurmas) {

        super(nome, idade, cpf, salario, setor, matricula);

        this.curso = curso;
        this.quantidadeTurmas = quantidadeTurmas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getQuantidadeTurmas() {
        return quantidadeTurmas;
    }

    public void setQuantidadeTurmas(int quantidadeTurmas) {
        this.quantidadeTurmas = quantidadeTurmas;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println("Curso: " + curso);
        System.out.println("Turmas coordenadas: " + quantidadeTurmas);
    }
}
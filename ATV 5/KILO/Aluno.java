package KILO;

public class Aluno extends Pessoa {

    private String matricula;
    private String curso;
    private double nota;

    public Aluno(
            String nome,
            int idade,
            String cpf,
            String matricula,
            String curso,
            double nota) {

        super(nome, idade, cpf);

        this.matricula = matricula;
        this.curso = curso;
        this.nota = nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Nota: " + nota);
    }
}
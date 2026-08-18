package KILO;

public class Professor extends Funcionario {

    private String disciplina;
    private int cargaHoraria;
    private String titulacao;

    public Professor(
            String nome,
            int idade,
            String cpf,
            double salario,
            String setor,
            String matricula,
            String disciplina,
            int cargaHoraria,
            String titulacao) {

        super(nome, idade, cpf, salario, setor, matricula);

        this.disciplina = disciplina;
        this.cargaHoraria = cargaHoraria;
        this.titulacao = titulacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public void apresentarDados() {
        super.apresentarDados();

        System.out.println("Disciplina: " + disciplina);
        System.out.println("Carga horária: " + cargaHoraria);
        System.out.println("Titulação: " + titulacao);
    }
}
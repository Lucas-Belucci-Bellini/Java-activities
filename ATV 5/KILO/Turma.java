package KILO;

import java.util.ArrayList;

public class Turma {

    private String codigo;
    private String nome;
    private Professor professor;

    private ArrayList<Aluno> alunos;

    public Turma(String codigo, String nome, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void listarAlunos() {

        System.out.println("===== TURMA =====");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Professor: " + professor.getNome());

        System.out.println("\nAlunos:");

        for (Aluno aluno : alunos) {
            System.out.println(
                    aluno.getMatricula()
                    + " - "
                    + aluno.getNome()
            );
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("João", 20);
        Professor professor = new Professor("Maria", "Java");

        aluno.apresentarAluno();
        professor.apresentarProfessor();
    }
}

package FOXTROT;

public class Main {

    public static void main(String[] args) {

        Professor professor = new Professor(
                "Capitão Jacob Keyes",
                "Matemática"
        );

        Escola escola = new Escola(
                "Academia Militar da UNSC",
                "Londrina - PR",
                "Particular",
                professor
        );

        escola.apresentarEscola();

        System.out.println();

        System.out.println("=== PROFESSOR INDEPENDENTE ===");
        professor.apresentarProfessor();
    }
}

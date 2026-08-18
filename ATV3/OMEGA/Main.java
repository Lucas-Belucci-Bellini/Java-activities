package OMEGA;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 256, 1899);
        Livro livro2 = new Livro("O Cortiço", "Aluísio Azevedo", 304, 1890);
        Livro livro3 = new Livro("A Hora da Estrela", "Clarice Lispector", 96, 1977);

        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);
    }
}

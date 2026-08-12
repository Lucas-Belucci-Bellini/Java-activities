package HOTEL;

public class Principal {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 256);
        Livro livro2 = new Livro("O Cortiço", "Aluísio Azevedo", 304);

        System.out.println("Livro 1:");
        livro1.apresentarLivro();

        System.out.println("\nLivro 2:");
        livro2.apresentarLivro();

        livro1.setTitulo("Memórias Póstumas de Brás Cubas");

        System.out.println("\nNúmero de páginas do Livro 1: " + livro1.getNumeroPaginas());

        System.out.println("\nLivro 1 atualizado:");
        livro1.apresentarLivro();
    }
}

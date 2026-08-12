package OMEGA;

public class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int numeroPaginas, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo
                + ", Autor: " + autor
                + ", Páginas: " + numeroPaginas
                + ", Ano de publicação: " + anoPublicacao;
    }
}

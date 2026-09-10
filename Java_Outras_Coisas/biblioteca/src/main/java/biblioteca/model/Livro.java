package biblioteca.model;

/**
 * Representa um livro cadastrado na biblioteca.
 */
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String categoria;
    private int quantidadeDisponivel;
    private String status;

    /**
     * Cria um livro completo.
     *
     * @param id identificador do livro
     * @param titulo titulo do livro
     * @param autor autor do livro
     * @param anoPublicacao ano de publicacao
     * @param categoria categoria do livro
     * @param quantidadeDisponivel quantidade disponivel para emprestimo
     * @param status status atual do livro
     */
    public Livro(int id, String titulo, String autor, int anoPublicacao,
                String categoria, int quantidadeDisponivel, String status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.status = quantidadeDisponivel > 0 ? "Disponível" : "Indisponível";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Atualiza o status de acordo com a quantidade disponível.
     */
    public void atualizarStatus() {
        this.status = quantidadeDisponivel > 0 ? "Disponível" : "Indisponível";
    }
}

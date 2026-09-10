package biblioteca.model;

import java.time.LocalDate;

/**
 * Representa um empréstimo de livro realizado por um usuário.
 */
public class Emprestimo {
    private int id;
    private int livroId;
    private int usuarioId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;

    /**
     * Cria um empréstimo ativo.
     *
     * @param id identificador do empréstimo
     * @param livroId id do livro emprestado
     * @param usuarioId id do usuário que pegou o livro
     */
    public Emprestimo(int id, int livroId, int usuarioId) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Registra a devolução do livro.
     */
    public void devolver() {
        this.ativo = false;
        this.dataDevolucao = LocalDate.now();
    }
}

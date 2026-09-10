package biblioteca.service;

import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe responsável pelas regras de negócio da biblioteca.
 */
public class BibliotecaService {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    /**
     * Cadastra um livro após validar os dados.
     *
     * @param livro dados do livro
     * @return mensagem de sucesso ou erro
     */
    public String cadastrarLivro(Livro livro) {
        if (livro == null) {
            return "Livro inválido.";
        }

        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            return "Título do livro é obrigatório.";
        }

        if (livro.getAutor() == null || livro.getAutor().isBlank()) {
            return "Autor do livro é obrigatório.";
        }

        if (livro.getQuantidadeDisponivel() <= 0) {
            return "A quantidade disponível deve ser maior que zero.";
        }

        for (Livro l : livros) {
            if (l.getId() == livro.getId()) {
                return "ID do livro já cadastrado.";
            }
        }

        livros.add(livro);
        livro.atualizarStatus();
        return "Livro cadastrado com sucesso.";
    }

    /**
     * Cadastra um usuário após validar os dados.
     *
     * @param usuario usuário a ser cadastrado
     * @return mensagem de sucesso ou erro
     */
    public String cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return "Usuário inválido.";
        }

        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            return "Nome do usuário é obrigatório.";
        }

        if (usuario.getCpf() == null || usuario.getCpf().isBlank()) {
            return "CPF do usuário é obrigatório.";
        }

        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId() || Objects.equals(u.getCpf(), usuario.getCpf())) {
                return "ID ou CPF já cadastrado.";
            }
        }

        usuarios.add(usuario);
        return "Usuário cadastrado com sucesso.";
    }

    /**
     * Busca livro por ID.
     *
     * @param id identificador do livro
     * @return livro encontrado ou null
     */
    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    /**
     * Busca usuário por ID.
     *
     * @param id identificador do usuário
     * @return usuário encontrado ou null
     */
    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Busca livros por título, autor ou categoria.
     *
     * @param termo termo de busca
     * @return lista de livros encontrados
     */
    public List<Livro> pesquisarLivro(String termo) {
        List<Livro> encontrados = new ArrayList<>();
        if (termo == null || termo.isBlank()) {
            return livros;
        }

        String valor = termo.toLowerCase();
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(valor)
                    || livro.getAutor().toLowerCase().contains(valor)
                    || livro.getCategoria().toLowerCase().contains(valor)) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    /**
     * Busca usuários por nome ou CPF.
     *
     * @param termo termo de busca
     * @return lista de usuários encontrados
     */
    public List<Usuario> pesquisarUsuario(String termo) {
        List<Usuario> encontrados = new ArrayList<>();
        if (termo == null || termo.isBlank()) {
            return usuarios;
        }

        String valor = termo.toLowerCase();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().toLowerCase().contains(valor)
                    || usuario.getCpf().toLowerCase().contains(valor)) {
                encontrados.add(usuario);
            }
        }
        return encontrados;
    }

    /**
     * Realiza empréstimo de livro.
     *
     * @param usuarioId id do usuário
     * @param livroId id do livro
     * @return mensagem com resultado da operação
     */
    public String realizarEmprestimo(int usuarioId, int livroId) {
        Usuario usuario = buscarUsuarioPorId(usuarioId);
        if (usuario == null) {
            return "Usuário inexistente.";
        }

        Livro livro = buscarLivroPorId(livroId);
        if (livro == null) {
            return "Livro inexistente.";
        }

        if (livro.getQuantidadeDisponivel() <= 0) {
            return "Livro indisponível para empréstimo.";
        }

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo() && emprestimo.getLivroId() == livroId && emprestimo.getUsuarioId() == usuarioId) {
                return "Esse usuário já possui esse livro em empréstimo ativo.";
            }
        }

        int novoId = emprestimos.size() + 1;
        Emprestimo emprestimo = new Emprestimo(novoId, livroId, usuarioId);
        emprestimos.add(emprestimo);
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);
        return "Empréstimo realizado com sucesso.";
    }

    /**
     * Registra a devolução de um empréstimo.
     *
     * @param emprestimoId id do empréstimo
     * @return mensagem de sucesso ou erro
     */
    public String devolverLivro(int emprestimoId) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == emprestimoId) {
                if (!emprestimo.isAtivo()) {
                    return "Esse empréstimo já foi devolvido.";
                }

                emprestimo.devolver();
                Livro livro = buscarLivroPorId(emprestimo.getLivroId());
                if (livro != null) {
                    livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1);
                }
                return "Devolução registrada com sucesso.";
            }
        }

        return "Empréstimo não encontrado.";
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public int quantidadeLivros() {
        return livros.size();
    }

    public int quantidadeUsuarios() {
        return usuarios.size();
    }

    public int quantidadeEmprestimosAtivos() {
        int total = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()) {
                total++;
            }
        }
        return total;
    }
}

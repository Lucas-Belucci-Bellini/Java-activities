package biblioteca.model;

/**
 * Representa um usuário da biblioteca.
 */
public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    /**
     * Cria um usuário.
     *
     * @param id identificador do usuário
     * @param nome nome completo
     * @param cpf cpf ou identificador principal
     * @param telefone telefone para contato
     * @param email email do usuário
     */
    public Usuario(int id, String nome, String cpf, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package locadora;

/**
 * Representa uma pessoa cadastrada como cliente da locadora.
 */
public class Cliente {

    private final String nome;
    private final int idade;
    private final int anosHabilitado;

    /**
     * Cria um cliente.
     *
     * @param nome nome do cliente
     * @param idade idade do cliente
     * @param anosHabilitado tempo de habilitacao em anos
     */
    public Cliente(String nome, int idade, int anosHabilitado) {
        this.nome = nome;
        this.idade = idade;
        this.anosHabilitado = anosHabilitado;
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a idade do cliente.
     *
     * @return idade do cliente
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Retorna o tempo de habilitacao do cliente.
     *
     * @return anos de habilitacao
     */
    public int getAnosHabilitado() {
        return anosHabilitado;
    }

    /**
     * Verifica se o cliente atende aos requisitos basicos para alugar um carro.
     *
     * @return {@code true} quando tem pelo menos 21 anos e dois anos de habilitacao
     */
    public boolean isApto() {
        return idade >= 21 && anosHabilitado >= 2;
    }
}

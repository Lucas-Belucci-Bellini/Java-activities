package locadora;

/**
 * Contrato comum para qualquer item que possa ser alugado.
 */
public interface Alugavel {

    /**
     * Calcula o valor cobrado por um dia de locacao.
     *
     * @return valor da diaria
     */
    double calcularValorDiaria();

    /**
     * Informa se o item esta disponivel para locacao.
     *
     * @return {@code true} quando o item esta disponivel
     */
    boolean isDisponivel();

    /**
     * Retorna uma descricao legivel do item.
     *
     * @return descricao do item
     */
    String getDescricao();
}

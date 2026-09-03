package locadora;

/**
 * Representa um seguro contratado para uma locacao.
 */
public class Seguro {

    private final String tipo;
    private final double valorDiario;

    /**
     * Cria um seguro.
     *
     * @param tipo descricao do tipo de seguro
     * @param valorDiario valor cobrado diariamente pelo seguro
     */
    public Seguro(String tipo, double valorDiario) {
        this.tipo = tipo;
        this.valorDiario = valorDiario;
    }

    /**
     * Retorna o tipo do seguro.
     *
     * @return tipo do seguro
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Retorna o valor diario do seguro.
     *
     * @return valor diario do seguro
     */
    public double getValorDiario() {
        return valorDiario;
    }
}

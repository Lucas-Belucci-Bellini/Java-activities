package locadora;

/**
 * Representa um seguro adicional de uma locacao.
 */
public class Seguro {

    private final String tipo;
    private final double valorDiario;

    /**
     * Cria um seguro.
     *
     * @param tipo tipo do seguro
     * @param valorDiario valor cobrado por dia
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
     * @return valor diario
     */
    public double getValorDiario() {
        return valorDiario;
    }
}

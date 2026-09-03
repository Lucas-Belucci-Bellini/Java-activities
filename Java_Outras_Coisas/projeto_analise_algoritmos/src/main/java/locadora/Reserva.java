package locadora;

/**
 * Registra a reserva de um item alugavel para um cliente.
 */
public class Reserva {

    private final String codigo;
    private final Cliente cliente;
    private final Alugavel alugavel;
    private final int dias;
    private boolean ativa;

    /**
     * Cria uma reserva ativa.
     *
     * @param codigo identificador da reserva
     * @param cliente cliente que fez a reserva
     * @param alugavel item reservado
     * @param dias quantidade de dias reservados
     */
    public Reserva(String codigo, Cliente cliente, Alugavel alugavel, int dias) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.alugavel = alugavel;
        this.dias = dias;
        this.ativa = true;
    }

    /**
     * Retorna o codigo da reserva.
     *
     * @return codigo da reserva
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna o cliente da reserva.
     *
     * @return cliente associado
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Retorna o item reservado.
     *
     * @return item alugavel associado
     */
    public Alugavel getAlugavel() {
        return alugavel;
    }

    /**
     * Retorna a quantidade de dias reservados.
     *
     * @return quantidade de dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * Informa se a reserva ainda esta ativa.
     *
     * @return {@code true} quando a reserva esta ativa
     */
    public boolean isAtiva() {
        return ativa;
    }

    /**
     * Cancela a reserva.
     */
    public void cancelar() {
        ativa = false;
    }

    /**
     * Calcula o valor das diarias previstas na reserva.
     *
     * @return valor total das diarias
     */
    public double calcularValorTotal() {
        return alugavel.calcularValorDiaria() * dias;
    }
}

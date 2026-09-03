package locadora;

/**
 * Representa o pagamento associado a uma reserva.
 */
public class Pagamento {

    private final Reserva reserva;
    private final double valor;
    private boolean confirmado;

    /**
     * Cria um pagamento ainda nao confirmado.
     *
     * @param reserva reserva que sera paga
     * @param valor valor pago
     */
    public Pagamento(Reserva reserva, double valor) {
        this.reserva = reserva;
        this.valor = valor;
        this.confirmado = false;
    }

    /**
     * Retorna a reserva relacionada ao pagamento.
     *
     * @return reserva associada
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * Retorna o valor do pagamento.
     *
     * @return valor pago
     */
    public double getValor() {
        return valor;
    }

    /**
     * Informa se o pagamento foi confirmado.
     *
     * @return {@code true} quando confirmado
     */
    public boolean isConfirmado() {
        return confirmado;
    }

    /**
     * Confirma o pagamento.
     */
    public void confirmar() {
        confirmado = true;
    }
}

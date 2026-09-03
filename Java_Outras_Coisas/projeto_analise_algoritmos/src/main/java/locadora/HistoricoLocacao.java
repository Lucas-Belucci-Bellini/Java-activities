package locadora;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mantem o historico de reservas registradas pela locadora.
 */
public class HistoricoLocacao {

    private final List<Reserva> reservas;

    /**
     * Cria um historico inicialmente vazio.
     */
    public HistoricoLocacao() {
        reservas = new ArrayList<>();
    }

    /**
     * Adiciona uma reserva ao historico.
     *
     * @param reserva reserva que sera registrada
     */
    public void registrar(Reserva reserva) {
        reservas.add(reserva);
    }

    /**
     * Retorna uma visao somente para leitura das reservas registradas.
     *
     * @return lista nao modificavel de reservas
     */
    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    /**
     * Conta as reservas ativas do historico.
     *
     * @return quantidade de reservas ativas
     */
    public int contarReservasAtivas() {
        int total = 0;
        for (Reserva reserva : reservas) {
            if (reserva.isAtiva()) {
                total++;
            }
        }
        return total;
    }

    /**
     * Soma o valor das reservas ativas.
     *
     * @return receita prevista das reservas ativas
     */
    public double calcularReceitaPrevista() {
        double total = 0;
        for (Reserva reserva : reservas) {
            if (reserva.isAtiva()) {
                total += reserva.calcularValorTotal();
            }
        }
        return total;
    }
}

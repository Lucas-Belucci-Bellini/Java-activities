package locadora;

/**
 * Representa um carro que pode ser alugado.
 */
public class Carro implements Alugavel {

    private final String placa;
    private final String modelo;
    private final double valorDiaria;
    private boolean disponivel;

    /**
     * Cria um carro inicialmente disponivel.
     *
     * @param placa identificacao do carro
     * @param modelo modelo do carro
     * @param valorDiaria valor da diaria
     */
    public Carro(String placa, String modelo, double valorDiaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    /**
     * Retorna a placa do carro.
     *
     * @return placa do carro
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Retorna o modelo do carro.
     *
     * @return modelo do carro
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Retorna o valor da diaria do carro.
     *
     * @return valor da diaria
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * Informa se o carro esta disponivel.
     *
     * @return {@code true} quando esta disponivel
     */
    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Altera a disponibilidade do carro.
     *
     * @param disponivel novo estado de disponibilidade
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Retorna a diaria do carro para o contrato de item alugavel.
     *
     * @return valor da diaria
     */
    @Override
    public double calcularValorDiaria() {
        return valorDiaria;
    }

    /**
     * Retorna uma descricao resumida do carro.
     *
     * @return modelo, placa e valor da diaria
     */
    @Override
    public String getDescricao() {
        return modelo + " (" + placa + ") - R$" + valorDiaria + "/dia";
    }
}

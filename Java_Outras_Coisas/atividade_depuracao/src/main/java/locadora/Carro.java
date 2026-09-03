package locadora;

/**
 * Representa um carro disponivel para locacao.
 */
public class Carro {

    private final String placa;
    private final String modelo;
    private final double valorDiaria;
    private boolean disponivel;

    /**
     * Cria um carro inicialmente disponivel.
     *
     * @param placa identificacao do carro
     * @param modelo modelo do carro
     * @param valorDiaria valor cobrado por dia de locacao
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
     * Retorna o valor da diaria.
     *
     * @return valor cobrado por dia
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * Informa se o carro esta disponivel para locacao.
     *
     * @return {@code true} quando o carro esta disponivel
     */
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Atualiza a disponibilidade do carro.
     *
     * @param disponivel novo estado de disponibilidade
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

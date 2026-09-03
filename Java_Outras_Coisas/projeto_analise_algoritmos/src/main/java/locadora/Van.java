package locadora;

/**
 * Representa uma van disponivel para locacao.
 */
public class Van implements Alugavel {

    private final String placa;
    private final String modelo;
    private final double capacidadeCarga;
    private final double valorBaseDiaria;
    private boolean disponivel;

    /**
     * Cria uma van inicialmente disponivel.
     * Cada unidade de capacidade de carga acrescenta R$0,02 a diaria base.
     *
     * @param placa identificacao da van
     * @param modelo modelo da van
     * @param capacidadeCarga capacidade de carga em quilogramas
     * @param valorBaseDiaria valor base da diaria
     */
    public Van(String placa, String modelo, double capacidadeCarga, double valorBaseDiaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeCarga = capacidadeCarga;
        this.valorBaseDiaria = valorBaseDiaria;
        this.disponivel = true;
    }

    /**
     * Retorna a placa da van.
     *
     * @return placa da van
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Retorna o modelo da van.
     *
     * @return modelo da van
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Retorna a capacidade de carga da van.
     *
     * @return capacidade em quilogramas
     */
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    /**
     * Calcula a diaria com adicional proporcional a capacidade de carga.
     *
     * @return valor da diaria
     */
    @Override
    public double calcularValorDiaria() {
        return valorBaseDiaria + capacidadeCarga * 0.02;
    }

    /**
     * Informa se a van esta disponivel.
     *
     * @return {@code true} quando esta disponivel
     */
    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Altera a disponibilidade da van.
     *
     * @param disponivel novo estado de disponibilidade
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Retorna uma descricao resumida da van.
     *
     * @return modelo, capacidade e valor da diaria
     */
    @Override
    public String getDescricao() {
        return modelo + " (" + capacidadeCarga + "kg) - R$" + calcularValorDiaria() + "/dia";
    }
}

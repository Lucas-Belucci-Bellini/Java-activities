package locadora;

/**
 * Representa uma moto disponivel para locacao.
 */
public class Moto implements Alugavel {

    private final String placa;
    private final String modelo;
    private final int cilindrada;
    private final double valorBaseDiaria;
    private boolean disponivel;

    /**
     * Cria uma moto inicialmente disponivel.
     * A cada 100 cilindradas, sao acrescentados R$5,00 a diaria base.
     *
     * @param placa identificacao da moto
     * @param modelo modelo da moto
     * @param cilindrada cilindrada em centimetros cubicos
     * @param valorBaseDiaria valor base da diaria
     */
    public Moto(String placa, String modelo, int cilindrada, double valorBaseDiaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.valorBaseDiaria = valorBaseDiaria;
        this.disponivel = true;
    }

    /**
     * Retorna a placa da moto.
     *
     * @return placa da moto
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Retorna o modelo da moto.
     *
     * @return modelo da moto
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Retorna a cilindrada da moto.
     *
     * @return cilindrada em centimetros cubicos
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * Calcula a diaria com adicional proporcional a cilindrada.
     *
     * @return valor da diaria
     */
    @Override
    public double calcularValorDiaria() {
        return valorBaseDiaria + cilindrada / 100.0 * 5;
    }

    /**
     * Informa se a moto esta disponivel.
     *
     * @return {@code true} quando esta disponivel
     */
    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Altera a disponibilidade da moto.
     *
     * @param disponivel novo estado de disponibilidade
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Retorna uma descricao resumida da moto.
     *
     * @return modelo, cilindrada e valor da diaria
     */
    @Override
    public String getDescricao() {
        return modelo + " (" + cilindrada + "cc) - R$" + calcularValorDiaria() + "/dia";
    }
}

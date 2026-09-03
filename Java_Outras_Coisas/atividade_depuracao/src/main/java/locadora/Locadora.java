package locadora;

/**
 * Fornece operacoes de calculo e consulta utilizadas pela locadora.
 */
public class Locadora {

    /**
     * Cria uma locadora pronta para executar os calculos de locacao.
     */
    public Locadora() {
    }

    /**
     * Calcula o valor total de uma locacao.
     *
     * @param valorDiaria valor cobrado por dia
     * @param dias quantidade de dias locados
     * @return valor total da locacao
     */
    public double calcularValorTotal(double valorDiaria, int dias) {
        return valorDiaria * dias;
    }

    /**
     * Calcula o valor diario a partir do valor total contratado.
     *
     * @param valorTotal valor total da locacao
     * @param diasContratados quantidade de dias contratados
     * @return valor cobrado por dia
     */
    public double calcularValorPorDia(int valorTotal, int diasContratados) {
        return (double) valorTotal / diasContratados;
    }

    /**
     * Retorna o modelo de um carro.
     *
     * @param carro carro consultado
     * @return modelo do carro
     */
    public String obterModeloCarro(Carro carro) {
        return carro.getModelo();
    }

    /**
     * Calcula a multa de acordo com os dias de atraso.
     *
     * @param diasAtraso quantidade de dias em atraso
     * @param multaPorDia valor da multa por dia
     * @return valor total da multa
     */
    public double calcularMultaAtraso(int diasAtraso, double multaPorDia) {
        return diasAtraso * multaPorDia;
    }

    /**
     * Retorna a primeira letra do modelo de um carro.
     *
     * @param carro carro consultado
     * @return primeira letra do modelo
     */
    public char obterPrimeiraLetraModelo(Carro carro) {
        return carro.getModelo().charAt(0);
    }

    /**
     * Aplica um desconto percentual ao valor informado.
     *
     * @param valor valor original
     * @param percentualDesconto percentual de desconto
     * @return valor final com desconto
     */
    public double calcularValorComDesconto(double valor, double percentualDesconto) {
        double valorDesconto = valor * percentualDesconto / 100;
        return valor - valorDesconto;
    }

    /**
     * Retorna o nome de um cliente.
     *
     * @param cliente cliente consultado
     * @return nome do cliente
     */
    public String obterNomeCliente(Cliente cliente) {
        return cliente.getNome();
    }

    /**
     * Classifica o carro pelo valor de sua diaria.
     *
     * @param carro carro consultado
     * @return {@code "CARRO DE LUXO"} para diarias acima de 1000; caso contrario,
     *         {@code "CARRO COMUM"}
     */
    public String obterDescricaoCarro(Carro carro) {
        String descricao = carro.getValorDiaria() > 1000 ? "Carro de luxo" : "Carro comum";
        return descricao.toUpperCase();
    }

    /**
     * Soma o valor diario do carro ao valor diario do seguro.
     *
     * @param carro carro da locacao
     * @param seguro seguro da locacao
     * @return custo diario com seguro
     */
    public double calcularValorComSeguro(Carro carro, Seguro seguro) {
        return carro.getValorDiaria() + seguro.getValorDiario();
    }

    /**
     * Verifica se cliente e carro estao aptos para uma locacao.
     *
     * @param cliente cliente que deseja alugar
     * @param carro carro que sera alugado
     * @return {@code true} somente quando o cliente esta apto e o carro esta disponivel
     */
    public boolean verificarClienteAptoParaCarro(Cliente cliente, Carro carro) {
        return cliente.isApto() && carro.isDisponivel();
    }
}

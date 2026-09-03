package locadora;

/**
 * Reune operacoes de consulta, precificacao e processamento de locacoes.
 */
public class Locadora {

    private static final double[] TABELA_PRECOS = {90.0, 130.0, 180.0};
    private static final int[] LIMIARES_DIAS = {3, 7, 15};
    private static final double[] DESCONTOS = {0.05, 0.10, 0.20};

    /**
     * Cria uma locadora sem estado inicial.
     */
    public Locadora() {
    }

    /**
     * Conta quantos carros da frota estao disponiveis.
     *
     * @param carros carros que serao analisados
     * @return quantidade de carros disponiveis
     */
    public int contarCarrosDisponiveis(Carro[] carros) {
        int total = 0;
        for (Carro carro : carros) {
            if (carro != null && carro.isDisponivel()) {
                total++;
            }
        }
        return total;
    }

    /**
     * Soma o valor da diaria de todos os carros da frota.
     *
     * @param carros carros que serao incluidos na soma
     * @return soma das diarias dos carros
     */
    public double calcularReceitaTotalFrota(Carro[] carros) {
        double total = 0;
        for (Carro carro : carros) {
            if (carro != null) {
                total += carro.getValorDiaria();
            }
        }
        return total;
    }

    /**
     * Calcula a media inteira de idade dos clientes informados.
     *
     * @param clientes clientes que serao analisados
     * @return media das idades ou zero quando nao ha clientes
     */
    public int calcularMediaIdadeClientes(Cliente[] clientes) {
        int soma = 0;
        int quantidade = 0;
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                soma += cliente.getIdade();
                quantidade++;
            }
        }
        return quantidade == 0 ? 0 : soma / quantidade;
    }

    /**
     * Busca, entre os clientes informados, o de maior idade.
     *
     * @param clientes clientes que serao pesquisados
     * @return cliente mais velho ou {@code null} quando a lista esta vazia
     */
    public Cliente buscarClienteMaisVelho(Cliente[] clientes) {
        Cliente maisVelho = null;
        for (Cliente cliente : clientes) {
            if (cliente != null && (maisVelho == null || cliente.getIdade() > maisVelho.getIdade())) {
                maisVelho = cliente;
            }
        }
        return maisVelho;
    }

    /**
     * Busca um carro pela placa e devolve uma descricao com modelo e valor da diaria.
     *
     * @param carros carros que serao pesquisados
     * @param placa placa procurada
     * @return descricao do carro ou uma mensagem quando ele nao for encontrado
     */
    public String buscarCarroPorPlaca(Carro[] carros, String placa) {
        for (Carro carro : carros) {
            if (carro != null && carro.getPlaca().equals(placa)) {
                return carro.getModelo() + " - R$" + carro.getValorDiaria() + "/dia";
            }
        }
        return "Carro nao encontrado";
    }

    /**
     * Calcula a multa por atraso, cobrando R$40,00 por dia de atraso.
     *
     * @param diasAtraso quantidade de dias em atraso
     * @return valor total da multa
     */
    public double calcularMultaAtraso(int diasAtraso) {
        double multaPorDia = 40;
        return multaPorDia * diasAtraso;
    }

    /**
     * Processa uma locacao completa, incluindo validacao, seguro e desconto.
     * O desconto de 15% e aplicado quando o cliente esta apto e a locacao tem
     * pelo menos sete dias.
     *
     * @param carro carro que sera alugado
     * @param cliente cliente responsavel pela locacao
     * @param seguro seguro contratado
     * @param dias quantidade de dias da locacao
     * @return valor final da locacao
     * @throws IllegalStateException quando o carro esta indisponivel
     */
    public double processarLocacaoCompleta(Carro carro, Cliente cliente, Seguro seguro, int dias) {
        validarLocacao(carro);
        double valorBruto = calcularValorBruto(carro, seguro, dias);
        return aplicarDescontosEEncargos(valorBruto, cliente, dias);
    }

    /**
     * Garante que o carro informado esta disponivel.
     *
     * @param carro carro que sera validado
     * @throws IllegalStateException quando o carro esta indisponivel
     */
    private void validarLocacao(Carro carro) {
        if (!carro.isDisponivel()) {
            throw new IllegalStateException("Carro indisponivel");
        }
    }

    /**
     * Calcula o valor bruto da locacao antes dos descontos.
     *
     * @param carro carro alugado
     * @param seguro seguro contratado
     * @param dias quantidade de dias
     * @return valor bruto
     */
    private double calcularValorBruto(Carro carro, Seguro seguro, int dias) {
        return (carro.getValorDiaria() + seguro.getValorDiario()) * dias;
    }

    /**
     * Aplica os descontos previstos ao valor bruto.
     *
     * @param valorBruto valor antes do desconto
     * @param cliente cliente da locacao
     * @param dias quantidade de dias
     * @return valor apos a aplicacao dos descontos
     */
    private double aplicarDescontosEEncargos(double valorBruto, Cliente cliente, int dias) {
        if (cliente.isApto() && dias >= 7) {
            return valorBruto * 0.85;
        }
        return valorBruto;
    }

    /**
     * Calcula o valor de uma locacao a partir da categoria do veiculo (0, 1 ou 2)
     * multiplicada pela quantidade de dias.
     *
     * @param categoria indice da categoria na tabela de precos
     * @param dias quantidade de dias
     * @return valor da locacao
     * @throws ArrayIndexOutOfBoundsException quando a categoria nao existe
     */
    public double calcularDiariaComCategoria(int categoria, int dias) {
        double valorDiaria = TABELA_PRECOS[categoria];
        return valorDiaria * dias;
    }

    /**
     * Gera um resumo com a quantidade de carros disponiveis e o valor medio
     * da diaria apenas desses carros.
     *
     * @param carros carros que serao resumidos
     * @return texto com quantidade e media das diarias disponiveis
     */
    public String gerarResumoFrota(Carro[] carros) {
        int disponiveis = 0;
        double somaValores = 0;
        for (Carro carro : carros) {
            if (carro != null && carro.isDisponivel()) {
                disponiveis++;
                somaValores += carro.getValorDiaria();
            }
        }
        double media = disponiveis == 0 ? 0 : somaValores / disponiveis;
        return disponiveis + " carro(s) disponivel(is), media de R$" + media + "/dia";
    }

    /**
     * Aplica desconto escalonado conforme a quantidade de dias: 5% a partir de
     * tres dias, 10% a partir de sete e 20% a partir de quinze.
     *
     * @param valorBase valor antes do desconto
     * @param dias quantidade de dias alugados
     * @return valor com o maior desconto aplicavel
     */
    public double calcularDescontoEscalonado(double valorBase, int dias) {
        double desconto = 0;
        for (int i = 0; i < LIMIARES_DIAS.length; i++) {
            if (dias >= LIMIARES_DIAS[i]) {
                desconto = DESCONTOS[i];
            }
        }
        return valorBase * (1 - desconto);
    }

    /**
     * Verifica se o cliente tem direito ao desconto de fidelidade.
     * Sao necessarios pelo menos 25 anos e tres locacoes anteriores.
     *
     * @param cliente cliente avaliado
     * @param totalLocacoesAnteriores quantidade de locacoes anteriores
     * @return {@code true} quando os dois requisitos sao atendidos
     */
    public boolean clienteElegivelDescontoFidelidade(Cliente cliente, int totalLocacoesAnteriores) {
        return cliente.getIdade() >= 25 && totalLocacoesAnteriores >= 3;
    }

    /**
     * Soma as diarias dos itens alugaveis fornecidos, independentemente do tipo.
     *
     * @param alugaveis itens que serao percorridos
     * @return soma das diarias dos itens nao nulos
     */
    public double calcularReceitaDiaria(Alugavel[] alugaveis) {
        double total = 0;
        for (Alugavel alugavel : alugaveis) {
            if (alugavel != null) {
                total += alugavel.calcularValorDiaria();
            }
        }
        return total;
    }
}

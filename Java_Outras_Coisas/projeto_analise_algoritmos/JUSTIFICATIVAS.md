# Justificativas - Parte 1 (Depuracao)

## 1. contarCarrosDisponiveis

**Tinha bug?** Nao, considerando uma frota sem elementos nulos.

**Explicacao:** O metodo ja percorria todos os carros e incrementava o total
somente quando `isDisponivel()` era verdadeiro. Mantive a ideia original e
acrescentei a verificacao de nulos para que um cadastro incompleto nao derrube
a contagem.

## 2. calcularReceitaTotalFrota

**Tinha bug?** Sim.

**Explicacao:** O laco comecava no indice 1, entao o primeiro carro nunca era
somado. A correcao percorre a frota desde o primeiro elemento e soma cada
diaria.

## 3. calcularMediaIdadeClientes

**Tinha bug?** Sim.

**Explicacao:** Com um array vazio, a divisao por `clientes.length` causava
`ArithmeticException`. Agora a quantidade de clientes validos e contada e o
metodo retorna zero quando nao existe cliente para calcular.

## 4. buscarClienteMaisVelho

**Tinha bug?** Nao.

**Explicacao:** O metodo inicializa o resultado com o primeiro cliente valido
encontrado e substitui esse resultado somente quando encontra idade maior.
Para uma lista vazia, retornar `null` representa corretamente que nao existe
cliente mais velho.

## 5. buscarCarroPorPlaca

**Tinha bug?** Sim.

**Explicacao:** Quando a placa nao existia, `encontrado` continuava `null` e o
acesso ao modelo causava `NullPointerException`. A busca agora retorna logo ao
encontrar o carro e informa `Carro nao encontrado` quando a pesquisa termina
sem resultado.

## 6. calcularMultaAtraso

**Tinha bug?** Sim.

**Explicacao:** O laco usava `i <= diasAtraso`, cobrando um dia a mais. A
correcao multiplica diretamente os dias de atraso por R$40,00, portanto tres
dias resultam em R$120,00.

## 7. processarLocacaoCompleta

**Tinha bug?** Sim.

**Explicacao:** A regra dizia que o desconto dependia de duas condicoes ao
mesmo tempo, mas o codigo usava `||`. Assim, um cliente inapto com sete dias
ganhava desconto indevidamente. A condicao foi alterada para `&&`.

## 8. calcularDiariaComCategoria

**Tinha bug?** Nao, para as categorias validas de 0 a 2.

**Explicacao:** A tabela possui tres precos e o indice informado seleciona a
categoria correta; depois o preco e multiplicado pelos dias. A documentacao
registra que uma categoria fora desse intervalo gera erro, em vez de esconder
um cadastro invalido.

## 9. gerarResumoFrota

**Tinha bug?** Nao.

**Explicacao:** O metodo conta apenas os carros disponiveis, soma somente as
diarias desses carros e evita divisao por zero quando nenhum esta disponivel.
Mantive esse comportamento e apenas ignorei referencias nulas.

## 10. calcularDescontoEscalonado

**Tinha bug?** Sim.

**Explicacao:** O laco usava `i <= LIMIARES_DIAS.length`, acessando uma
posicao depois do fim dos vetores e causando `ArrayIndexOutOfBoundsException`.
Com `i < LIMIARES_DIAS.length`, os tres niveis sao percorridos corretamente e
o ultimo desconto aplicavel permanece selecionado.

## 11. clienteElegivelDescontoFidelidade

**Tinha bug?** Sim.

**Explicacao:** A regra exigia pelo menos 25 anos, mas o codigo usava `> 25`.
A comparacao passou a ser `>= 25`, mantendo tambem a exigencia de pelo menos
tres locacoes anteriores.

## Parte 2 - Extensao de POO

Escolhi `Alugavel` como interface porque carro, moto e van possuem dados
diferentes, mas compartilham as tres operacoes essenciais da locacao: calcular
a diaria, informar disponibilidade e fornecer uma descricao. Assim, a
`Locadora` consegue percorrer um array de `Alugavel` sem testar o tipo concreto
de cada objeto.

`Carro` passou a implementar a interface. `Moto` usa a cilindrada para aplicar
um adicional sobre a diaria base, enquanto `Van` usa a capacidade de carga para
calcular outro adicional. O metodo `calcularReceitaDiaria` soma as diarias de
um array misto e demonstra o polimorfismo.

Tambem foram criadas `Reserva`, `Pagamento` e `HistoricoLocacao`. A reserva
associa cliente, item alugavel e quantidade de dias; o pagamento registra o
valor e sua confirmacao; e o historico registra reservas, conta as ativas e
calcula a receita prevista. Essas classes foram separadas para manter cada
responsabilidade pequena e preservar o encapsulamento dos dados.

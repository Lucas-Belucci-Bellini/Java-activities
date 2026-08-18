package KILO;

import java.util.ArrayList;

public class BancoDados {

    private ArrayList<Pessoa> pessoas;

    public BancoDados() {
        pessoas = new ArrayList<>();
    }

    public void adicionar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public Pessoa buscarPorNome(String nome) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }

        return null;
    }

    public Pessoa buscarPorCpf(String cpf) {

        for (Pessoa pessoa : pessoas) {

            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }

        return null;
    }

    public void listarTudo() {

        System.out.println("\n===== BANCO DE DADOS =====");

        for (Pessoa pessoa : pessoas) {

            System.out.println("-------------------------");

            pessoa.apresentarDados();
        }
    }

    public int quantidadePessoas() {
        return pessoas.size();
    }
}
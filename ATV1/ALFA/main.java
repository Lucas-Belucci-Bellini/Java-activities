package ATV1.ALFA;

public class main {
        public static void main(String[] args) {
                Produto produto1 = new Produto("Livro Amarelo - Projeto Missão", 89.90, 50);
                Produto produto2 = new Produto("Livro Amarelo (Edição Capa Dura)", 89.90, 15);

                System.out.println("--- DADOS DOS PRODUTOS ---");
                produto1.apresentarProduto();
                produto2.apresentarProduto();
        }
}
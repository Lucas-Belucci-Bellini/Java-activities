package biblioteca;

import biblioteca.controller.BibliotecaController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Classe principal que inicia o servidor HTTP da biblioteca.
 */
public class Main {

    /**
     * Inicia o servidor e registra os endpoints da API e os arquivos estáticos.
     *
     * @param args argumentos da linha de comando
     * @throws IOException quando ocorre erro de acesso ao servidor HTTP
     */
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        BibliotecaController controller = new BibliotecaController();
        controller.configure(server);
        server.start();

        System.out.println("Servidor da Biblioteca rodando em http://localhost:8080");
        System.out.println("Acesse /index.html para abrir a interface web.");
    }
}

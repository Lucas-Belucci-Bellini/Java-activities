package biblioteca.controller;

import biblioteca.model.Emprestimo;
import biblioteca.model.Livro;
import biblioteca.model.Usuario;
import biblioteca.service.BibliotecaService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controlador responsável por receber as requisições HTTP da interface web.
 */
public class BibliotecaController {
    private final BibliotecaService service = new BibliotecaService();

    /**
     * Registra os endpoints do sistema no servidor HTTP.
     *
     * @param server servidor HTTP em execução
     */
    public void configure(HttpServer server) {
        server.createContext("/", new StaticFileHandler());
        server.createContext("/api/livros", new LivrosHandler());
        server.createContext("/api/usuarios", new UsuariosHandler());
        server.createContext("/api/emprestimos", new EmprestimosHandler());
        server.createContext("/api/dashboard", new DashboardHandler());

        Livro l1 = new Livro(1, "Java para Iniciantes", "Ana Silva", 2023, "Programação", 3, "Disponível");
        Livro l2 = new Livro(2, "Estruturas de Dados", "Carlos Souza", 2021, "Tecnologia", 2, "Disponível");
        service.cadastrarLivro(l1);
        service.cadastrarLivro(l2);

        Usuario u1 = new Usuario(1, "Maria Souza", "12345678900", "11999998888", "maria@email.com");
        Usuario u2 = new Usuario(2, "João Pereira", "09876543211", "11888887777", "joao@email.com");
        service.cadastrarUsuario(u1);
        service.cadastrarUsuario(u2);
    }

    /**
     * Lida com os arquivos estáticos HTML, CSS e JS.
     */
    private class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            URI uri = exchange.getRequestURI();
            String path = uri.getPath();
            if (path == null || path.equals("/")) {
                path = "/index.html";
            }

            Path file = Path.of(System.getProperty("user.dir"), "web", path.replace("/", ""));
            if (!Files.exists(file)) {
                byte[] notFound = "Página não encontrada.".getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
                exchange.sendResponseHeaders(404, notFound.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(notFound);
                }
                return;
            }

            byte[] content = Files.readAllBytes(file);
            exchange.getResponseHeaders().set("Content-Type", contentTypeFor(path));
            exchange.sendResponseHeaders(200, content.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(content);
            }
        }
    }

    /**
     * Retorna o tipo MIME correto para cada arquivo.
     *
     * @param path caminho do arquivo
     * @return tipo MIME
     */
    private String contentTypeFor(String path) {
        if (path.endsWith(".html")) return "text/html; charset=UTF-8";
        if (path.endsWith(".css")) return "text/css; charset=UTF-8";
        if (path.endsWith(".js")) return "application/javascript; charset=UTF-8";
        return "text/plain; charset=UTF-8";
    }

    /**
     * Processa as operações relacionadas a livros.
     */
    private class LivrosHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String response = "";

            if ("GET".equalsIgnoreCase(method)) {
                String termo = queryParam(exchange, "termo");
                response = toJson(service.pesquisarLivro(termo));
            } else if ("POST".equalsIgnoreCase(method)) {
                Map<String, String> params = readForm(exchange);
                int id = Integer.parseInt(params.getOrDefault("id", "0"));
                String titulo = params.getOrDefault("titulo", "");
                String autor = params.getOrDefault("autor", "");
                int ano = Integer.parseInt(params.getOrDefault("anoPublicacao", "0"));
                String categoria = params.getOrDefault("categoria", "");
                int quantidade = Integer.parseInt(params.getOrDefault("quantidadeDisponivel", "0"));
                String status = params.getOrDefault("status", "Disponível");

                Livro livro = new Livro(id, titulo, autor, ano, categoria, quantidade, status);
                response = "{\"mensagem\":\"" + service.cadastrarLivro(livro).replace("\"", "\\\"") + "\"}";
            }

            sendJson(exchange, response);
        }
    }

    /**
     * Processa as operações relacionadas a usuários.
     */
    private class UsuariosHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String response = "";

            if ("GET".equalsIgnoreCase(method)) {
                String termo = queryParam(exchange, "termo");
                response = toJson(service.pesquisarUsuario(termo));
            } else if ("POST".equalsIgnoreCase(method)) {
                Map<String, String> params = readForm(exchange);
                int id = Integer.parseInt(params.getOrDefault("id", "0"));
                String nome = params.getOrDefault("nome", "");
                String cpf = params.getOrDefault("cpf", "");
                String telefone = params.getOrDefault("telefone", "");
                String email = params.getOrDefault("email", "");

                Usuario usuario = new Usuario(id, nome, cpf, telefone, email);
                response = "{\"mensagem\":\"" + service.cadastrarUsuario(usuario).replace("\"", "\\\"") + "\"}";
            }

            sendJson(exchange, response);
        }
    }

    /**
     * Processa as operações relacionadas a empréstimos.
     */
    private class EmprestimosHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String response = "";

            if ("GET".equalsIgnoreCase(method)) {
                response = toJson(service.getEmprestimos());
            } else if ("POST".equalsIgnoreCase(method)) {
                Map<String, String> params = readForm(exchange);
                String action = params.getOrDefault("action", "emprestar");

                if ("emprestar".equals(action)) {
                    int usuarioId = Integer.parseInt(params.getOrDefault("usuarioId", "0"));
                    int livroId = Integer.parseInt(params.getOrDefault("livroId", "0"));
                    response = "{\"mensagem\":\"" + service.realizarEmprestimo(usuarioId, livroId).replace("\"", "\\\"") + "\"}";
                } else if ("devolver".equals(action)) {
                    int emprestimoId = Integer.parseInt(params.getOrDefault("emprestimoId", "0"));
                    response = "{\"mensagem\":\"" + service.devolverLivro(emprestimoId).replace("\"", "\\\"") + "\"}";
                }
            }

            sendJson(exchange, response);
        }
    }

    /**
     * Retorna os dados do dashboard inicial.
     */
    private class DashboardHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "{"
                    + "\"livros\":" + service.quantidadeLivros() + ","
                    + "\"usuarios\":" + service.quantidadeUsuarios() + ","
                    + "\"emprestimosAtivos\":" + service.quantidadeEmprestimosAtivos() + "}"
                    ;
            sendJson(exchange, response);
        }
    }

    /**
     * Converte uma lista para JSON simples.
     *
     * @param data lista a ser convertida
     * @return conteúdo JSON
     */
    private String toJson(List<?> data) {
        if (data == null || data.isEmpty()) {
            return "[]";
        }

        return data.stream()
                .map(obj -> obj.toString().replace("=", ":").replace("[", "{").replace("]", "}"))
                .collect(Collectors.joining(",", "[", "]"));
    }

    /**
     * Lê os parâmetros enviados pelo formulário HTML.
     *
     * @param exchange troca HTTP
     * @return mapa das chaves e valores
     * @throws IOException quando há erro de leitura
     */
    private Map<String, String> readForm(HttpExchange exchange) throws IOException {
        byte[] bodyBytes = exchange.getRequestBody().readAllBytes();
        String body = new String(bodyBytes, StandardCharsets.UTF_8);
        if (body.isBlank()) {
            return Map.of();
        }

        return java.util.Arrays.stream(body.split("&"))
                .map(part -> part.split("=", 2))
                .collect(Collectors.toMap(
                        p -> java.net.URLDecoder.decode(p[0], StandardCharsets.UTF_8),
                        p -> p.length > 1 ? java.net.URLDecoder.decode(p[1], StandardCharsets.UTF_8) : "",
                        (a, b) -> b,
                        java.util.HashMap::new
                ));
    }

    /**
     * Recupera um parâmetro de query string da requisição.
     *
     * @param exchange troca HTTP
     * @param name nome do parâmetro
     * @return valor encontrado ou vazio
     */
    private String queryParam(HttpExchange exchange, String name) {
        String query = exchange.getRequestURI().getRawQuery();
        if (query == null || query.isBlank()) {
            return "";
        }
        for (String param : query.split("&")) {
            String[] item = param.split("=", 2);
            if (item.length == 2 && item[0].equals(name)) {
                return java.net.URLDecoder.decode(item[1], StandardCharsets.UTF_8);
            }
        }
        return "";
    }

    /**
     * Envia resposta em JSON para o cliente.
     *
     * @param exchange troca HTTP
     * @param response corpo JSON
     * @throws IOException quando há erro na resposta
     */
    private void sendJson(HttpExchange exchange, String response) throws IOException {
        byte[] body = response.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, body.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body);
        }
    }
}

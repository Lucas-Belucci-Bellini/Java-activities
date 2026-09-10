# Sistema de Biblioteca em Java + HTML/CSS

## Visão geral

Este projeto simula uma biblioteca com as entidades principais:

- Livro
- Usuario
- Emprestimo
- BibliotecaService
- BibliotecaController

A parte visual foi desenvolvida em HTML e CSS, enquanto o processamento e as regras de negócio ficam em Java.

---

## Estrutura do projeto

```text
biblioteca/
├── pom.xml
├── README.md
├── src/
│   └── main/
│       └── java/
│           └── biblioteca/
│               ├── Main.java
│               ├── controller/
│               │   └── BibliotecaController.java
│               ├── model/
│               │   ├── Livro.java
│               │   ├── Usuario.java
│               │   └── Emprestimo.java
│               └── service/
│                   └── BibliotecaService.java
└── web/
    ├── index.html
    ├── style.css
    └── script.js
```

---

## Como a comunicação HTML → Java → HTML funciona

O fluxo é o seguinte:

1. O usuário preenche um formulário em HTML.
2. O JavaScript envia os dados via fetch para o servidor Java.
3. O `BibliotecaController` recebe a requisição HTTP.
4. O controller chama o `BibliotecaService`.
5. O serviço aplica as regras de negócio.
6. O Java retorna uma resposta em JSON.
7. O JavaScript recebe a resposta e mostra na tela.

Exemplo simplificado:

```text
HTML form -> JavaScript -> fetch('/api/livros') -> BibliotecaController -> BibliotecaService -> JSON -> HTML
```

---

## Classes principais

### Livro
Representa um livro com:

- id
- titulo
- autor
- anoPublicacao
- categoria
- quantidadeDisponivel
- status

### Usuario
Representa um usuário com:

- id
- nome
- cpf
- telefone
- email

### Emprestimo
Representa um empréstimo com:

- id
- livroId
- usuarioId
- dataEmprestimo
- dataDevolucao
- ativo

### BibliotecaService
Classe responsável por todas as regras de negócio:

- cadastrar livro
- cadastrar usuário
- pesquisar livro
- pesquisar usuário
- realizar empréstimo
- devolver livro
- validar regras

### BibliotecaController
Classe responsável por receber requisições HTTP e encaminhar para o serviço.

---

## Regras de negócio implementadas

- livro com quantidade zero não pode ser emprestado
- usuário inexistente não pode pegar livro
- livro inexistente não pode ser emprestado
- empréstimo não pode ser devolvido duas vezes
- IDs de livro e usuário precisam ser únicos
- dados enviados devem ser validados antes do processamento

---

## Como executar

1. Abra o terminal na pasta do projeto.
2. Execute:

```bash
mvn clean compile
```

3. Rode a aplicação:

```bash
mvn exec:java -Dexec.mainClass=biblioteca.Main
```

Caso o `exec-maven-plugin` não esteja configurado, use:

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out biblioteca.Main
```

4. Abra no navegador:

```text
http://localhost:8080/index.html
```

---

## Observação importante

Esse projeto é um sistema em memória, ou seja, os dados ficam armazenados enquanto a aplicação estiver rodando. Quando o servidor parar, os dados são perdidos.

Esse padrão é suficiente para exercícios acadêmicos e demonstração da comunicação entre interface e Java.

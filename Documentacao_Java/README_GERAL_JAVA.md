# Guia de Java do zero até o que você fez hoje

Este arquivo foi pensado para quem está começando do zero e quer entender o que aprendeu até agora.

## 1) O que é Java?

Java é uma linguagem de programação orientada a objetos. Ela é usada para criar:

- aplicativos desktop
- sistemas web
- APIs
- apps Android
- softwares empresariais
- jogos e ferramentas
- automações e sistemas de gestão

Java é conhecida por:

- ser orientada a objetos
- ser fortemente tipada
- ter boa organização por classes e pacotes
- funcionar em várias plataformas
- ser usada em grandes projetos

---

## 2) O que é classe?

Uma classe é um modelo ou planta de um objeto.

Exemplo:

```java
public class Carro {
    String modelo;
    int ano;

    void acelerar() {
        System.out.println("Carro acelerando");
    }
}
```

Aqui a classe `Carro` define:

- atributos: modelo, ano
- método: acelerar()

---

## 3) O que é objeto?

Um objeto é uma instância concreta de uma classe.

```java
Carro meuCarro = new Carro();
meuCarro.modelo = "Onix";
meuCarro.ano = 2024;
meuCarro.acelerar();
```

Você cria um objeto com `new` e depois usa seus atributos e métodos.

---

## 4) Atributos e métodos

### Atributos
São as características do objeto.

```java
String nome;
int idade;
double saldo;
```

### Métodos
São as ações que o objeto pode fazer.

```java
void apresentarDados() {
    System.out.println("Nome: " + nome);
}
```

---

## 5) Pacotes

Pacotes ajudam a organizar as classes.

```java
package locadora;
```

Em Java, o pacote define a categoria do código. Isso ajuda a separar classes por sistema, módulo ou funcionalidade.

---

## 6) Encapsulamento

Encapsulamento significa proteger os dados e permitir acesso por métodos.

```java
public class ContaBancaria {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
```

Isso evita que o dado seja alterado diretamente sem controle.

---

## 7) Herança

Herança permite que uma classe herde atributos e métodos de outra.

```java
public class Animal {
    public void emitirSom() {
        System.out.println("Som do animal");
    }
}

public class Cachorro extends Animal {
    public void latir() {
        System.out.println("Au au");
    }
}
```

A classe `Cachorro` herda `emitirSom()` da classe `Animal`.

---

## 8) Polimorfismo

Polimorfismo permite que um objeto seja tratado como uma classe mais genérica.

```java
Animal a = new Cachorro();
a.emitirSom();
```

A variável `a` é do tipo `Animal`, mas aponta para um objeto `Cachorro`.

---

## 9) Interface

Interface define um contrato do que uma classe precisa ter.

```java
public interface Alugavel {
    double calcularValorDiaria();
    boolean isDisponivel();
}
```

Uma classe implementa a interface:

```java
public class Carro implements Alugavel {
    public double calcularValorDiaria() {
        return 120.0;
    }

    public boolean isDisponivel() {
        return true;
    }
}
```

---

## 10) Arrays e coleções

Arrays guardam vários valores do mesmo tipo.

```java
int[] numeros = {1, 2, 3, 4};
```

Laço para percorrer:

```java
for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}
```

Listas também são muito usadas:

```java
ArrayList<String> nomes = new ArrayList<>();
nomes.add("Ana");
```

---

## 11) Condições e laços

### If / else

```java
if (idade >= 18) {
    System.out.println("Maior de idade");
} else {
    System.out.println("Menor de idade");
}
```

### For

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### While

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

---

## 12) Método main

`main` é o ponto de entrada do programa.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Java!");
    }
}
```

Toda aplicação Java começa por esse método.

---

## 13) Javadoc

Javadoc serve para documentar classes, métodos e atributos.

```java
/**
 * Classe que representa um produto.
 */
public class Produto {
    /**
     * Calcula o valor total do produto.
     * @return valor final
     */
    public double calcularPreco() {
        return 0;
    }
}
```

Isso gera documentação HTML automática para a sua aplicação.

---

## 14) Como os seus códigos se encaixam nisso?

Você fez projetos que usam quase todos esses conceitos:

### Classes e objetos
- `Produto`
- `Carro`
- `Funcionario`
- `Paciente`
- `Professor`
- `Livro`

### Herança
- `Animal` → `Cachorro`, `Gato`
- `Forma` → `Circulo`, `Retangulo`
- `ContaBancaria` → `ContaPoupanca`
- `Funcionario` → `Gerente`, `Vendedor`, `Estagiario`

### Encapsulamento
- atributos privados com getters e setters
- controle de acesso em `ContaBancaria`, `Pessoa`, `Aluno`, `Professor`

### Polimorfismo e interface
- `Alugavel`
- `Carro`, `Moto`, `Van`

### Lógica de negócio
- locadora, reservas, pagamentos, historico
- descontos, receitas, validações

---

## 15) Resumo de tudo que você já fez

As atividades que você criou usam conceitos como:

- classes
- atributos e métodos
- construtores
- estruturas de controle
- encapsulamento
- herança
- polimorfismo
- arrays
- interfaces
- objetos de domínio
- Javadoc

Você já está muito além do nível de “só copiar código”. Você já entende a ideia de construir entidades, relacionar dados e criar programas com lógica.

---

## 16) Erros comuns que apareceram

Alguns erros que aparecem no Java são muito comuns:

- `cannot find symbol` → a classe ou variável não foi encontrada
- `package ... does not match` → o pacote e a pasta não batem
- `class Main` sem `public static void main` → programa não inicia
- `;` ou `{}` faltando
- nome de arquivo diferente do nome da classe

Esses erros são normais quando você está aprendendo. O importante é corrigir o ponto exato e entender a causa.

---

## 17) O que você aprendeu até agora

Apesar de ainda estar começando, você já trabalhou com:

- criação de classes
- objetos e atributos
- herança
- abstração
- encapsulamento
- uso de `main`
- manipulação de dados
- criação de pequenos sistemas reais em console
- documentação em JavaDoc

Esse é um caminho muito bom para quem está aprendendo Java.

---

## 18) O próximo passo

Para evoluir, o ideal é continuar praticando esses exercícios em ordem:

1. sempre criar classes simples
2. depois fazer relacionamento entre elas
3. depois praticar herança
4. depois interface e polimorfismo
5. depois sistemas com listas e menus
6. depois documentar tudo com Javadoc

Se você revisar esse guia junto com os códigos das atividades, vai perceber que tudo que você aprendeu se conecta.

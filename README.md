# 🧮 CalculadoraApp — Testes Unitários com JUnit 5 e Mockito

Projeto desenvolvido como parte do módulo de **Testes de Software** do curso de **Análise e Desenvolvimento de Sistemas**. O objetivo é praticar a escrita de testes unitários em Java, cobrindo diferentes cenários: testes simples, testes de exceções e uso de mocks com Mockito.

---

## 🛠️ Tecnologias Utilizadas

| Ferramenta | Versão | Função |
|---|---|---|
| Java | 25 | Linguagem principal |
| Maven | — | Gerenciamento de dependências e build |
| JUnit Jupiter | 5.12.2 | Framework de testes unitários |
| Mockito Core | 4.11.0 | Criação de objetos simulados (mocks) |
| Mockito JUnit Jupiter | 4.11.0 | Integração do Mockito com o JUnit 5 |

---

## 🗂️ Estrutura do Projeto

O projeto está dividido em três pacotes, cada um com suas classes de produção e de teste:

```
src/
├── main/java/
│   ├── calculadora/
│   │   ├── CalculadoraApp.java          # Operações básicas: soma e divisão de inteiros
│   │   ├── CalculadoraFinanceira.java   # Soma valores em reais com conversão de moeda
│   │   ├── ConversorDeMoeda.java        # Interface para conversão dólar → real
│   │   └── Desconto.java               # Lógica de desconto progressivo por quantidade
│   ├── biblioteca/
│   │   ├── Livro.java                  # Entidade com título, autor e ISBN
│   │   ├── RepositorioDeLivros.java    # Armazena e busca livros por ISBN
│   │   └── ServicoDeEmprestimo.java   # Verifica disponibilidade e realiza empréstimo
│   └── pedidos/
│       ├── Pedido.java                 # Entidade com id e descrição
│       ├── RepositorioDePedidos.java   # Interface para busca de pedidos por id
│       └── ServicoDePedido.java       # Retorna a descrição de um pedido pelo id
│
└── test/java/
    ├── calculadora/
    │   ├── CalculadoraAppTest.java         # Testa soma, divisão e exceção
    │   ├── CalculadoraFinanceiraTest.java  # Testa soma com mock do conversor
    │   └── DescontoTest.java              # Testa as faixas de desconto progressivo
    ├── biblioteca/
    │   └── ServicoDeEmprestimoTest.java   # Testa empréstimo com repositório real
    └── pedidos/
        └── ServicoDePedidosTest.java      # Testa descrição do pedido com mock
```

---

## 📦 Dependências (`pom.xml`)

O Maven gerencia as dependências do projeto. O `<scope>test</scope>` garante que os frameworks de teste sejam usados apenas durante a fase de testes, sem serem empacotados na aplicação final.

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.12.2</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.11.0</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>4.11.0</version>
    <scope>test</scope>
</dependency>
```

---

## 🔍 Frameworks

### JUnit Jupiter (JUnit 5)
Framework de testes unitários para Java. Permite escrever e executar testes automatizados através de anotações, com suporte a ciclo de vida dos testes, asserções e extensões.

### Mockito
Framework de mocking que permite criar **objetos simulados** de interfaces e classes. Usado quando a classe a ser testada depende de algo externo (como um repositório ou serviço), permitindo isolar apenas a lógica que interessa testar.

---

## 🏷️ Anotações Utilizadas

### JUnit 5

| Anotação | Onde foi usada | O que faz |
|---|---|---|
| `@Test` | Em todos os arquivos de teste | Marca um método como caso de teste. O JUnit executa cada método anotado individualmente. |
| `@BeforeEach` | `CalculadoraAppTest` | Executado **antes de cada** `@Test`. Usado para instanciar o objeto `CalculadoraApp` antes de cada teste, garantindo que cada teste parta de um estado limpo. |
| `@AfterEach` | `CalculadoraAppTest` | Executado **depois de cada** `@Test`. Usado para atribuir `null` ao objeto `calc`, liberando memória após cada execução. |
| `@ExtendWith(MockitoExtension.class)` | `CalculadoraFinanceiraTest`, `ServicoDePedidosTest` | Registra a extensão do Mockito no JUnit 5, habilitando as anotações `@Mock` e `@InjectMocks` na classe. |

### Mockito

| Anotação | Onde foi usada | O que faz |
|---|---|---|
| `@Mock` | `CalculadoraFinanceiraTest`, `ServicoDePedidosTest` | Cria um objeto simulado (mock) da interface indicada. O mock não executa lógica real; o comportamento é definido com `when(...).thenReturn(...)`. |
| `@InjectMocks` | `CalculadoraFinanceiraTest`, `ServicoDePedidosTest` | Cria uma instância da classe indicada e injeta automaticamente os mocks declarados com `@Mock` no seu construtor. |

---

## ✅ Asserções Utilizadas

Todas as asserções vêm de `org.junit.jupiter.api.Assertions`.

| Asserção | Onde foi usada | O que verifica |
|---|---|---|
| `assertEquals(esperado, resultado)` | Todos os testes | Se o valor obtido é igual ao esperado. Aceita uma mensagem opcional como terceiro argumento para exibir em caso de falha. |
| `assertTrue(condicao)` | `ServicoDeEmprestimoTest` | Se a condição é verdadeira. Usado para confirmar que o empréstimo foi realizado com sucesso. |
| `assertFalse(condicao)` | `ServicoDeEmprestimoTest` | Se a condição é falsa. Usado para confirmar que um livro inexistente não pode ser emprestado. |
| `assertThrows(Excecao.class, () -> { ... })` | `CalculadoraAppTest` | Se o bloco de código lança a exceção esperada. Retorna a exceção capturada para que a mensagem possa ser inspecionada com `assertEquals`. |

---

## 🎭 Métodos do Mockito Utilizados

| Método | Onde foi usado | O que faz |
|---|---|---|
| `when(mock.metodo()).thenReturn(valor)` | `CalculadoraFinanceiraTest`, `ServicoDePedidosTest` | Define o comportamento do mock: quando o método for chamado com aquele argumento, retorna o valor especificado sem executar lógica real. |
| `verify(mock).metodo(argumento)` | `CalculadoraFinanceiraTest` | Verifica se o método do mock foi de fato chamado com o argumento correto durante a execução do teste. |

---

## 🧪 Casos de Teste

### `CalculadoraAppTest`
Testa a classe `CalculadoraApp` usando `@BeforeEach` e `@AfterEach` para gerenciar o ciclo de vida do objeto.

- **`testSoma`** — verifica que `somaInteiros(3, 5)` retorna `8`.
- **`testDivide`** — verifica que `divideInteiros(10, 5)` retorna `2`.
- **`testDivisaoPorZeroLancaExcecaoComMensagemCorreta`** — verifica que `dividir(10, 0)` lança `ArithmeticException` com a mensagem `"Divisão por zero não permitida."`.

### `CalculadoraFinanceiraTest`
Testa a classe `CalculadoraFinanceira` usando Mockito para simular a interface `ConversorDeMoeda`, sem depender de uma implementação real de conversão de câmbio.

- **`deveSomarValorEmReaisComValorConvertidoDeDolar`** — simula que `dolarParaReal(10.0)` retorna `50.0` e verifica que `somarEmReais(100.0, 10.0)` resulta em `150.0`. Usa `verify` para confirmar que o mock foi chamado corretamente.

### `DescontoTest`
Testa as três faixas de desconto progressivo da classe `Desconto`.

- **`testDesconto5`** — quantidade `9` deve resultar em `5%` de desconto.
- **`testDesconto10`** — quantidade `19` deve resultar em `10%` de desconto.
- **`testDesconto15`** — quantidade `29` deve resultar em `15%` de desconto.

### `ServicoDeEmprestimoTest`
Testa a classe `ServicoDeEmprestimo` com um `RepositorioDeLivros` **real** (sem mock), seguindo o padrão **Arrange / Act / Assert**.

- **`deveEmprestarLivroExistente`** — adiciona um livro ao repositório e verifica que o empréstimo retorna `true`.
- **`naoDeveEmprestarLivroInexistente`** — usa um repositório vazio e verifica que a tentativa de empréstimo retorna `false`.

### `ServicoDePedidosTest`
Testa a classe `ServicoDePedido` usando Mockito para simular a interface `RepositorioDePedidos`.

- **`deveRetornarDescricaoDoPedido`** — simula que `buscarPorId(1)` retorna um pedido falso e verifica que o serviço retorna a descrição `"Pedido de teste."`.

---

## 📐 Padrão Arrange / Act / Assert (AAA)

Os testes seguem o padrão **AAA**, que organiza cada teste em três etapas claras:

```java
// arrange — prepara o cenário e os dados
RepositorioDeLivros repositorio = new RepositorioDeLivros();
repositorio.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "123"));
ServicoDeEmprestimo servico = new ServicoDeEmprestimo(repositorio);

// act — executa a ação a ser testada
boolean emprestado = servico.emprestarLivro("123");

// assert — verifica o resultado
assertTrue(emprestado);
```

---

## ▶️ Como Executar os Testes

Com o Maven instalado, execute na raiz do projeto:

```bash
mvn test
```

---

## 📚 Referências

- [Documentação oficial do JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
- [Documentação oficial do Mockito](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Apache Maven](https://maven.apache.org/)

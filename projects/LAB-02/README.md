# LAB-02: Controle de Fluxo

Este código Java implementa um contador simples que recebe dois valores do usuário (valor inicial e valor final) e imprime os números entre eles. A lógica principal está no método `contar`, que verifica se os parâmetros são válidos (valor final maior que o valor inicial) e, em seguida, itera de `valorInicial + 1` até `valorFinal`, imprimindo cada número.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Scanner:** Classe para entrada de dados do usuário.
* **Tratamento de Exceções:** Garante a robustez do código com `try-catch-finally`.


## Tratamento de Erros

O código utiliza tratamento de exceções para lidar com situações em que o usuário insere valores inválidos. Uma exceção personalizada,`ParametrosInvalidosException`, é lançada quando o valor final não é maior que o valor inicial. O bloco `try-catch` captura essa exceção, imprime uma mensagem de erro amigável e solicita ao usuário que insira valores válidos. O bloco `finally` garante que o scanner seja fechado, evitando vazamentos de recursos.

## Aprendizado

* **Entrada de Dados:** Uso da classe `Scanner` para obter valores do usuário.
* **Tratamento de Exceções:** Criação e lançamento de exceções personalizadas, uso de `try-catch-finally` para lidar com erros de forma elegante.
* **Laços:** Uso do laço `for` para iterar sobre um intervalo de números.
* **Formatação de Saída:** Uso de `System.out.printf` para formatar a saída com números.

## Como usar

* **Compilação:** Abra o terminal e navegue até o diretório do projeto. Execute o comando `javac Contador.java` para compilar o código.
* **Execução:** Digite `java Contador` no terminal para iniciar o programa.

**Exemplo de Uso:**

```
Digite o valor inicial: 5
Digite o valor final: 10

Contagem:
Número 6
Número 7
Número 8
Número 9
Número 10
```


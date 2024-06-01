# LAB-01: Simulador de Conta Bancária em Java Através Do Terminal/Console

Este projeto oferece uma simulação simplificada de uma conta bancária através do terminal/console, utilizando a linguagem Java. Ele serve como um exercício prático para aprimorar os conhecimentos de sintaxe básica em Java, incluindo:

* **Declaração de variáveis:** Criação de espaços na memória para armazenar informações como nome, agência, número da conta e saldo.
* **Entrada de dados via terminal:** Utilização da classe `Scanner` para coletar informações inseridas pelo usuário.
* **Manipulação de strings:** Formatação e exibição de mensagens personalizadas com os dados da conta.

## Funcionalidades

* **Abertura de conta:** Coleta os dados do cliente (nome completo, agência, número da conta e saldo inicial) e exibe uma mensagem de confirmação.
* **Formatação de dados:** Utiliza o `Locale.US` para garantir a formatação correta de números decimais com ponto (`.`) como separador.
* **Exibição de informações:** Apresenta os dados da conta em um formato organizado e de fácil leitura.

## Como usar

* **Compilação:** Abra o terminal e navegue até o diretório do projeto. Execute o comando `javac ContaTerminal.java` para compilar o código.
* **Execução:** Digite `java ContaTerminal` no terminal para iniciar o programa.
* **Entrada de dados:** Siga as instruções no terminal e insira as informações solicitadas (nome, sobrenome, agência, número da conta e saldo inicial).
* **Resultado:** O programa exibirá uma mensagem de sucesso com os dados da conta criada.

## Exemplo

```
==========================================
 BEM-VINDO AO BANCO **VIRTUS BANK**
==========================================
Nome: João da Silva
Sobrenome: Oliveira
Agência (com dígito): 1234-5
Número da conta: 98765
Valor do depósito inicial: 500.00

==========================================
 CONTA CRIADA COM SUCESSO!
==========================================
Titular: João da Silva Oliveira
Agência: 1234-5
Conta: 98765
Saldo inicial: R$ 500.00
==========================================
```

## Observações

* O código utiliza o bloco `try-with-resources` para garantir o fechamento automático do `Scanner` após o uso, evitando vazamentos de recursos.

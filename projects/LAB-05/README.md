# LAB-05: Abstraindo um Bootcamp Usando Orientação a Objetos em Java

Este projeto Java simula um sistema de gerenciamento de bootcamps, permitindo a criação de bootcamps com cursos, mentorias e desafios de projeto. Os devs podem se inscrever em bootcamps, progredir nos conteúdos e acumular XP.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Orientação a Objetos:** Para modelar bootcamps, conteúdos e devs.
* **Collections (Set, List):** Para armazenar e gerenciar dados.

## Aprendizado

Durante o desenvolvimento deste projeto, foram aplicados e consolidados os seguintes conceitos:

* **Abstração:** Criação de classes abstratas (`Conteudo`) para representar diferentes tipos de conteúdo.
* **Encapsulamento:** Uso de getters e setters para controlar o acesso aos atributos das classes.
* **Herança:** Criação de classes derivadas (`Curso`,`Mentoria`,`DesafioDeProjeto`) que herdam da classe base `Conteudo`.
* **Polimorfismo:** Implementação do método `calcularXp()` de forma diferente em cada subclasse de `Conteudo`.
* **Collections:** Utilização de `Set` (para evitar duplicatas) e `List` (para manter a ordem de inserção) para armazenar conteúdos e devs.

## Exemplo de Uso

Java

```
Bootcamp bootcamp = Bootcamps.bootcamp(); // Cria um bootcamp com os conteúdos predefinidos

Dev devVicente = Alunos.criarDevVicente(); // Cria um dev e o inscreve no bootcamp
Dev devChavatte = Alunos.criarDevChavatte(); // Cria outro dev e o inscreve no bootcamp

System.out.println(bootcamp); // Imprime informações sobre o bootcamp

Progresso.exibirProgressoDev(devVicente); // Exibe o progresso do dev no bootcamp
Progresso.exibirProgressoDev(devChavatte); // Exibe o progresso do outro dev
```

## Conclusão

Este projeto demonstra a aplicação prática de conceitos de orientação a objetos em Java para criar um sistema simples, mas funcional, de gerenciamento de bootcamps. Ele serve como base para o desenvolvimento de sistemas mais complexos, como plataformas de ensino online.



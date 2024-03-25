# Exercício Prático 1

## O contexto

Uma empresa está desenvolvendo um sistema de gerenciamento ágil de _software_. Uma das funcionalidades é apoiar os desenvolvedores durante o *planning poker*, uma técnica de estimativa. Em uma sessão de *planning poker*, os desenvolvedores estimam o esforço necessário para construir uma funcionalidade específica do _backlog_. Depois que a equipe discute a funcionalidade, cada desenvolvedor fornece uma estimativa: um número que varia de um a qualquer número que a equipe defina. Números mais altos significam mais esforço para implementar a funcionalidade. Por exemplo, um desenvolvedor que estima que um recurso vale oito pontos espera que ele exija quatro vezes mais esforço do que um desenvolvedor que estima que o recurso valha dois pontos. O desenvolvedor com a menor estimativa e o desenvolvedor com a maior estimativa explicam seus pontos de vista aos outros membros da equipe. Depois de mais discussões, o *planning poker* se repete até que os membros da equipe concordem sobre quanto esforço o recurso levará.

O método apresentado a seguir foi implementado por um desenvolvedor. Tal método faz parte do núcleo da funcionalidade de *planning poker*. Este método recebe uma lista de estimativas e produz, como saída, os nomes dos dois desenvolvedores que devem explicar seus pontos de vista. Os detalhes são mostrados a seguir:

> **Método:** `identifyExtremes` - O método deve receber uma lista de desenvolvedores e suas respectivas estimativas e retornar os dois desenvolvedores com as estimativas mais extremas.
> 
> **Entrada:** Uma lista de estimativas (`Estimate`), cada uma contendo o nome do desenvolvedor e sua estimativa.
> 
> **Saída:** Uma lista de `Strings` contendo o nome do desenvolvedor com a estimativa mais baixa e o nome do desenvolvedor com a estimativa mais alta.

## O código implementado

```java
public class PlanningPoker {
    public List<String> identifyExtremes(List<Estimate> estimates) {
        Estimate lowestEstimate = null;
        Estimate highestEstimate = null;
        for(Estimate estimate: estimates) {
            if (highestEstimate == null || 
                estimate.getEstimate() > highestEstimate.getEstimate()) {
                highestEstimate = estimate;
            }
            else if(lowestEstimate == null || 
                estimate.getEstimate() < lowestEstimate.getEstimate()) {
                lowestEstimate = estimate;
            } 
        }
        
        return Arrays.asList(
                lowestEstimate.getDeveloper(),
                highestEstimate.getDeveloper()
        );
    }
}
```

## Exercício prático

Implemente casos de teste usando JUnit. Para cada caso de teste deve haver uma explicação justificando o porquê você escreveu o caso de teste. Por exemplo, explicando o que está testando testar, ou quais bugs gostaria de descobrir ou, ainda, quais propriedades do código está preservando. Enfim, cada caso de teste tem um motivo para existir, tente argumentar sobre a necessidade da existência de cada um. A explicação deve ser em formato de comentário logo acima de cada caso de teste.
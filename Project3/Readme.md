# Teste Baseado em Propriedade

Teste baseado em propriedade é uma abordagem de teste onde, ao invés de verificar um comportamento específico com entradas predefinidas (como em testes unitários tradicionais), define-se propriedades gerais que o código deve satisfazer para uma vasta gama de entradas. Em seguida, o _framework_ gera automaticamente muitas combinações diferentes de entradas para verificar se a propriedade se mantém verdadeira.

## O que é Jqwik?

[Jqwik](https://jqwik.net/) é uma biblioteca de teste baseada em propriedades para a linguagem de programação Java. Ele permite gerar dados de teste automaticamente e verificar propriedades que devem sempre ser verdadeiras para as funções testadas.

### Dependência

Para utilizar o Jqwik, adicione a seguinte dependência no arquivo `pom.xml` do seu projeto:

```xml
<dependencies>
    ...
    <dependency>
        <groupId>net.jqwik</groupId>
        <artifactId>jqwik</artifactId>
        <version>1.9.0</version>
        <scope>test</scope>
    </dependency>
    ...
</dependencies>
```
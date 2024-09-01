# Trabalho Prático de Teste Baseado em Propriedade

**Autor**<br>
[Gustavo Zanzin Guerreiro Martins](https://www.linkedin.com/in/gustavo-martinx/)


## Introdução

Teste baseado em propriedade é uma abordagem de teste na qual, ao invés de verificar um comportamento específico com entradas predefinidas (como em testes unitários tradicionais), define-se propriedades gerais que o código deve satisfazer para uma vasta gama de entradas. Em seguida, o _framework_ (neste caso, o [Jqwik](https://jqwik.net/)) gera automaticamente muitas combinações diferentes de entradas para verificar se a propriedade se mantém verdadeira.

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

## Como executar os testes

1 - Instale as dependências do seu projeto.
```
mvn install
```

2 - Execute os testes usando o seguinte comando no terminal dentro do diretório do seu projeto. Isso irá compilar seu código e executar todos os testes no projeto.
```
mvn clean test
```

3 - Gere relatorio de cobertura dos testes usando o seguinte comando no terminal dentro do diretório do seu projeto.

- Obs.: Para acessar o relatório gerado pelo Jacoco, acesse o arquivo `index.html` presente em `target/site/jacoco/`.
```
mvn jacoco:report
mvn surefire-report:report
mvn site
```

- Comando para executar a ferramenta pitest para realizar testes de mutação:
```
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```
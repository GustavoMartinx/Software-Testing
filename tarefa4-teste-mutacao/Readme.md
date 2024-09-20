# Testes de Mutação

Testes de mutação são uma técnica de teste de software que introduzem pequenas modificações (ou mutações) no código-fonte de um programa. Por exemplo, em uma condição de um programa, uma mutação pode ser a troca de um operador `>` por um `<`. O programa modificado é conhecido como mutante.

A eficácia do teste de mutação é medida pela capacidade dos casos de teste em "matar" os mutantes, ou seja, detectar que o comportamento do código modificado é incorreto. A ideia é gerar um grande número de mutantes para verificar se os testes existentes conseguem identificar as falhas resultantes dessas alterações no código. Se os testes forem efetivos, eles deverão falhar quando o código estiver incorreto, indicando que o código testado é um mutante. Quando todos os mutantes são detectados, o conjunto de testes é considerado mais robusto. No entanto, se alguns mutantes não forem identificados, eles são chamados de "mutantes sobreviventes", o que pode indicar que os testes não cobrem adequadamente o código ou que a mutação não impacta significativamente a lógica do programa. Caso os testes falhem no código original, mas passem em um mutante, isso pode revelar um defeito no programa original ou uma falha no próprio caso de teste.

Em Java, uma das ferramentas mais populares tanto para automatizar a execução dos testes quanto para a geração de mutantes é o [Pitest](https://pitest.org/). Para mais detalhes sobre quais tipos de modificações o Pitest introduz, consulte [pitest.org/quickstart/mutators/](https://pitest.org/quickstart/mutators/).

## Como fazer testes de mutação em Java usando Pitest

### 1 - Configure o Projeto

Adicione a dependência do Pitest ao `pom.xml` do seu projeto:

```xml
<dependencies>

    <dependency>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.15.8</version>
    </dependency>

</dependencies>
```

E o plugin do Pitest também ao `pom.xml`:

```xml
<build>
    <plugins>

        <plugin>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-maven</artifactId>
            <version>1.15.8</version>
            <configuration>
                <mutators>
                    <mutator>ALL</mutator>
                </mutators>
            </configuration>
        </plugin>

    </plugins>
</build>
```

> Nota: Caso essas configurações mencionadas não funcionem como esperado, você pode optar por copiar o conteúdo do arquivo `pom.xml` deste projeto (alterando as linhas 7 e 8 com as informações do seu projeto).

### 2 - Execute o Pitest

Com os testes unitários já escritos e o projeto configurado, ao executar o comando a seguir, a ferramenta ficará responsável por criar os mutantes e executar a suíte de testes sobre cada um deles.

```bash
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

### 3 - Verifique os Resultados

Após a execução dos testes de mutação, também é possível visualizar a cobertura obtida por meio do relatório em HTML gerado pelo Pitest, que pode ser encontrado na pasta `target/pit-reports`. Entre outras, o relatório contém informações sobre:

- Quantidade de mutantes gerados;
- Quais foram as alterações de cada mutante;
- Mutações que os testes capturaram (mutações "mortas");
- Mutações que não foram capturadas (mutações "vivas");
- Informações de cobertura de código.

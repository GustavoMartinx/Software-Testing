# Teste de Software - Projetos Práticos
Este repositório contém uma coleção de projetos desenvolvidos como parte da disciplina de Teste de Software (OPT024) ministrada pelo professor [Dr. Reginaldo Ré](https://br.linkedin.com/in/reginaldo-r%C3%A9-0328aa30). Cada pasta do repositório representa um projeto independente, com um software a ser testado e casos de teste associados que validam o comportamento correto do programa, abordando diferentes conceitos de teste. O objetivo é aplicar as técnicas de teste estudadas em situações práticas.

A disciplina abordou, de forma generalista e conceitual (isto é, independente de tecnologias), os conceitos de teste baseado em especificação, teste estrutural, cobertura de código, _design by contracts_, teste de mutação, teste baseado em propriedades, dublês de teste, _test-driven development_ (TDD), entre outros.

Para a aplicação das técnicas de teste, foram desenvolvidos 9 projetos. Em todos eles utilizou-se a linguagem de programação Java, o _framework_ de teste [JUnit 5](https://junit.org/) e o gerenciador de dependências [Apache Maven](https://maven.apache.org/).

### Índice
1. [Lista de Projetos](#lista-de-projetos)<br>
1.1. [Teste Baseado em Especificação - Projeto 1 e Tarefa 2](#teste-baseado-em-especificação---projeto-1-e-tarefa-2)<br>
1.2. [Teste Estrutural e Cobertura de Código - Projeto 2 e Tarefa 3](#teste-estrutural-e-cobertura-de-código---projeto-2-e-tarefa-3)<br>
1.3. [Teste de Mutação - Tarefa 4](#teste-de-mutação---tarefa-4)<br>
1.4. [Teste Baseado em Propriedades - Projeto 3](#teste-baseado-em-propriedades---projeto-3)<br>
1.5. [Dublês de Teste e Mocks - Tarefa 5](#dublês-de-teste-e-mocks---tarefa-5)<br>
1.6. [Test Driven Development - Projeto 4](#test-driven-development---projeto-4)<br>
2. [Como criar um projeto Java com Maven](#como-criar-um-projeto-java-com-maven)
3. [Como compilar e executar um projeto Java com Maven](#como-compilar-e-executar-um-projeto-java-com-maven)
4. [Como executar um teste Java com Maven no VSCode](#como-executar-um-teste-java-com-maven-no-vscode)
5. [Referências Bibliográficas](#referências-bibliográficas)


## Lista de Projetos

### Teste Baseado em Especificação - Projeto 1 e Tarefa 2
Em Teste Baseado em Especificação, os casos de teste são derivados a partir das especificações de requisitos do sistema. O objetivo é garantir que o sistema atenda às expectativas definidas, validando se ele se comporta conforme a especificação, sem considerar sua implementação interna.

Nesse sentido, tanto o [Projeto 1](https://github.com/GustavoMartinx/Software-Testing/tree/main/Projeto1-Baseado-em-Especificacao) quanto a [Tarefa 2](https://github.com/GustavoMartinx/Software-Testing/tree/main/tarefa2-baseado-em-especificacao) aplicam os conceitos de teste baseado em especificação. Ambos compartilham a mesma estrutura de relatório técnico (arquivo `Relatorio.md` de cada pasta) utilizada para descrever o passo-a-passo da elaboração da suíte de testes usando essa técnica.

### Teste Estrutural e Cobertura de Código - Projeto 2 e Tarefa 3
Já em Teste Estrutural, a ideia é oposta; examina-se a estrutura interna do código-fonte para garantir que todas as suas partes foram verificadas. Diferente do teste baseado em especificação, este foca diretamente na lógica de implementação, avaliando, fluxos de controle e condições lógicas. Testes estruturais são frequentemente associados a métricas de cobertura de código, ajudando a identificar áreas do código que ainda não foram testadas.

Cobertura de Código é uma métrica usada para avaliar a eficácia dos testes de software, medindo a porcentagem do código que foi executada durante os testes. Quanto maior a cobertura, maior a confiança de que o sistema foi suficientemente verificado. Existem vários níveis de cobertura, como cobertura de linhas, de ramos ou de condições, cada um verificando diferentes aspectos do comportamento do programa.

Nesse contexto, a [Tarefa 3](https://github.com/GustavoMartinx/Software-Testing/blob/main/tarefa3-mc-dc/criterio_mcdc.md) descreve um exemplo de aplicação do critério MC/DC em uma decisão lógica. O critério MC/DC (_Modified Condition/Decision Coverage_) é uma técnica avançada de cobertura de código que exige que cada condição dentro de uma decisão lógica afete o resultado dessa decisão de forma independente.

Dito isso, o [Projeto 2](https://github.com/GustavoMartinx/Software-Testing/tree/main/Projeto2-Teste-Estrutural) cria uma suíte de testes baseados em especificação e, em seguida, a incrementa com a derivação de testes estruturais por meio da utilização do critério MC/DC. O trabalho empregou a ferramenta de análise de cobertura de código [JaCoCo](https://github.com/jacoco/jacoco) (Java Code Coverage) para medir o quanto do código-fonte foi testado. Além disso, todo o processo foi documentado no arquivo `Relatorio.md`.

### Teste de Mutação - Tarefa 4
A técnica de Testes de Mutação verifica a qualidade do software por meio da inserção de pequenas alterações (mutações) no código-fonte, gerando versões modificadas chamadas de _mutantes_. O objetivo é avaliar se os testes conseguem identificar as alterações errôneas no comportamento do programa. Se os testes falharem ao executar um mutante, isso indica que os casos de teste são eficazes. Caso contrário, o mutante "sobrevive", sugerindo que o conjunto de testes pode ser insuficiente ou que a mutação não afeta significativamente a lógica do programa.

Desse modo, a [Tarefa 4](https://github.com/GustavoMartinx/Software-Testing/blob/main/tarefa4-teste-mutacao/) busca, com uma suíte de testes qualquer, efetuar testes de mutação através da ferramenta [Pitest](https://pitest.org/). Ela auxilia tanto na geração de mutantes quanto na automatização da execução da suíte sobre cada um deles.

### Teste Baseado em Propriedades - Projeto 3
Em Teste Baseado em Propriedade, ao invés de verificar um comportamento específico com entradas predefinidas (como em testes unitários tradicionais), define-se propriedades gerais que o código deve satisfazer para uma vasta gama de entradas. Em seguida, um _framework_ (no caso do [Projeto 3](https://github.com/GustavoMartinx/Software-Testing/tree/main/Projeto3-Baseado-em-Propriedade), o [Jqwik](https://jqwik.net/)) gera automaticamente muitas combinações diferentes de entradas para verificar se a propriedade se mantém verdadeira.

### Dublês de Teste e Mocks - Tarefa 5
Dublês de Teste são objetos ou componentes criados para simular o comportamento de dependências reais em um cenário de teste, quando essas dependências são complexas, externas ou não estão disponíveis. Eles ajudam a isolar a unidade sendo testada, eliminando interferências externas. Para a [Tarefa 5](https://github.com/GustavoMartinx/Software-Testing/blob/main/tarefa5-dubles-de-teste), buscou-se utilizar o _framework_ de _mocking_ para Java [Mockito](https://site.mockito.org/).

### Test Driven Development - Projeto 4
TDD é uma prática de desenvolvimento de software em que os testes são escritos antes do código de produção. O ciclo do TDD segue três etapas principais, conhecidas como _*Red-Green-Refactor*_, explicadas no documento `Readme.md` do [Projeto 4](https://github.com/GustavoMartinx/Software-Testing/tree/main/Projeto4-Test-Driven-Development).

<br>

## Como criar um projeto Java com Maven

**1 -** Execute o seguinte comando para iniciar a criação de um projeto com Maven interativamente:

```bash	
mvn archetype:generate
```

**2 -** Após executar o comando, um diálogo será iniciado. Pressione Enter duas vezes para continuar.

**3 -** Digite o ``groupId``, que geralmente é a identificação única do projeto no formato de domínio reverso (por exemplo, ``com.meuprojeto`` ou `edu.utfpr`), e pressione Enter.

**4 -**  Digite o identificador do artefato (artifactId) e pressione Enter. O identificador do artefato é o nome do seu projeto, sem espaços ou caracteres especiais.

**5 -** Digite a versão do projeto (version) e pressione Enter. A versão é geralmente ``1.0-SNAPSHOT`` para um projeto inicial.

**6 -** Digite o pacote base (package) e pressione Enter. O pacote base é o pacote Java principal para as classes do seu projeto, como `projeto` (que resultaria em ``com.exemplo.projeto``).

**7 -** Confirme pressionando Enter para finalizar.

**8 -** Para a fase "_package_" que inclui a compilação do código-fonte, a execução de testes e o empacotamento do artefato resultante, execute:

```bash
cd <projectName>
mvn package
```
<br>

## Como compilar e executar um projeto Java com Maven

```bash
mvn compile exec:java -Dexec.mainClass="<package_name>.App"
```

<br>

## Como executar um teste Java com Maven no VSCode
1 - Certifique-se de que o Java e o Maven estejam instalados em seu sistema. Verifique executando no terminal:

```bash
java -version
```

```bash
mvn -v
```

2 - Abra o VSCode e abra a pasta do seu projeto Java.

3 - Instale a extensão "Java Extension Pack" no VSCode, que inclui suporte para o JUnit.

4 - Certifique-se de que o arquivo de teste esteja localizado em um diretório de teste padrão do Maven, como `src/test/java`.

5 - Execute os testes usando o seguinte comando no terminal dentro do diretório do seu projeto (no mesmo diretório do arquivo `pom.xml`). Isso irá compilar seu código e executar todos os testes no projeto.

```bash
mvn test
```
É possível executar um caso de teste específico usando a opção `-Dtest` seguida do nome da classe de teste:

```bash
mvn test -Dtest=<package_name>.<test_class_name>
```

## Referências Bibliográficas

Aniche, M.; **_Effective Software Testing: A Developer's Guide_**. New York, USA: Manning Publications Co., 2022. 328p. ISBN 9781633439931.

Delamaro, M.E.; Jino, M.; Maldonado, J.C.; **Introdução ao Teste de Software**. São Paulo, SP: Elsevier, 2016. 448p. ISBN 9788535283532. 
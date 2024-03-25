# Teste de Software
Este repositório tem como objetivo armazenar os projetos e atividades desenvolvidos durante a disciplina de Teste de Software.

## Como criar um projeto Java com Maven

**1 -** Execute o seguinte comando para iniciar a criação de um projeto com Maven interativamente:

```bash	
mvn archetype:generate
```

**2 -** Um diálogo iniciará, pressione Enter 2x para continuar.

**3 -** Digite o nome de algo (que não sei oq é - groupId) e pressione Enter.

**4 -** Digite o nome do projeto (acho - artifactId) e pressione Enter.

**5 -** Digite o nome do pacote (acho - version) e pressione Enter.

**6 -** Digite o nome do pacote (acho - package) e pressione Enter.

**7 -** Confirme pressionando Enter para finalizar.

```bash
cd <projectName>
mvn package
```
<br>

## Como compilar e executar um projeto Java com Maven

**1 -** Execute o seguinte comando na raiz do projteto (onde fica o arquivo pom.xml) para compilar seu código:
```bash
mvn compile
```

**2 -** Em seguida execute o seguinte comando para executar o projeto:

- Note que o comando ``-cp target/classes`` indica ao Java onde encontrar as classes compiladas.

```bash
java -cp target/classes <packageName>.App
```
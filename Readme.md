# Teste de Software
Este repositório tem como objetivo armazenar os projetos e atividades desenvolvidos durante a disciplina de Teste de Software.

<br>

## Como criar um projeto Java com Maven

**1 -** Execute o seguinte comando para iniciar a criação de um projeto com Maven interativamente:

```bash	
mvn archetype:generate
```

**2 -** Após executar o comando, um diálogo será iniciado. Pressione Enter duas vezes para continuar.

**3 -** Digite o ``groupId``, que geralmente é a identificação única do projeto no formato de domínio reverso (por exemplo, ``com.meuprojeto``), e pressione Enter.

**4 -**  Digite o identificador do artefato (artifactId) e pressione Enter. O identificador do artefato é o nome do seu projeto, sem espaços ou caracteres especiais.

**5 -** Digite a versão do projeto (version) e pressione Enter. A versão é geralmente ``1.0-SNAPSHOT`` para um projeto inicial.

**6 -** Digite o pacote base (package) e pressione Enter. O pacote base é o pacote Java principal para as classes do seu projeto, como ``com.exemplo.projeto``.

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

5 - Execute os testes usando o seguinte comando no terminal dentro do diretório do seu projeto. Isso irá compilar seu código e executar todos os testes no projeto.

```bash
mvn test
```
- Se pode executar um caso de teste específico usando a opção `-Dtest` seguida do nome da classe de teste

```bash
mvn test -Dtest=<package_name>.<test_class_name>
```

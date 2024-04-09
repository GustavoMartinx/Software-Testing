# Trabalho Prático de Teste Baseado em Especificação

Método para adição de números inteiros muito, muito grandes

<br>

Author

Gustavo Zanzin Guerreiro Martins


## Introdução

Este documento descreve o processo utilizado para derivar casos de teste para o método `add()` da classe `Add`. O método realiza a operação de adição de dois números inteiros de qualquer tamanho. Perceba que esse problema parece ser um _toy example_, mas é útil em computação científica uma vez que para certas aplicações é necessário fazer cáculos matemáticos com números inteiros muito, muito grandes. Nessa situação, os tipos básicos e os operadores matemáticos das linguagens de programação não suportam o cáculo.

O Passo 1 consiste em compreender os requisitos da entidade a ser testada. Sendo assim, este relatório descreverá a partir do Passo 2.


## Passo 2 - Explorar o funcionamento do programa

O processo executado foi:

- Observar um caso de funcionamento comum. A lista `left` será populada com o valor `[1]` e a lista `right` com o valor `[2]` ;
    - <(`left=[1]`, `right=[2]`), (`[3]`)>


## Passo 3 - Identificar as partições

### Para cada entrada individualmente

Como no método `validateIdentifier()` existe apenas um parâmetro, ele será o único a ser analisado.

### Parâmetro `s`:

O argumento `s` pode ser qualquer _string_. A especificação diz que o identificador deve iniciar com pelo menos uma letra. Nos requisitos é também abordado o comprimento do parâmetro, a saber, mínimo 1 e máximo 6. Nesse sentido, serão verificadas as partições a seguir:

- partição comum/esperada
    -  `len(s) >= 1 && len(s) <= 6` e `s` cujo primeiro caractere é uma letra e pode ser seguida de alguns dígitos e/ou letras ou não;

- apenas letras
    - `len(s) >= 1 && len(s) <= 6`;
    - `len(s) >= 7`;

- apenas dígitos.
 
Além disso, os casos nulos e vazios também serão testados, porque são sempre bons casos de teste excepcionais.

- `s` vazia `""`;
- `s` com valor `null`;

### Para combinações de entrada

Como já mencionado, o método a ser testado conta com apenas um parâmetro de entrada. Sendo assim, não é possível combinar valores diferentes em diferentes argumentos na entrada de tal método.

### Para saídas esperadas

Investigando as possíveis saídas, nota-se que o método `validateIdentifier()` pode retornar apenas um booleano, isto é, `true` ou `false`.

## Passo 4 - Identificar os valores limites

Defeitos nos limites do domínio de entrada são comuns em sistemas de _software_. Quando cria-se partições, elas assumem valores limites próximos que “dividem” as partições equivalentes. Sempre que um valor limite é identificado, é essencial testar o que acontece com o programa quando as entradas vão de um limite para o outro. Ou seja, teste de dois pontos quando há um valor limite. Um teste é para o _in point_ , que é o ponto que está dentro da partição; e o outro teste é para o _off point_, que é o ponto mais próximo do valor limite que pertence à partição à qual o _in point_ não pertence, isto é, a outra partição.

No caso de `validateIdentifier()`, um limite acontece quando a _string_ de entrada assume valores de comprimento de caracteres entre 1 e 7, passando (possivelmente) de uma saída `true` para `false`.

Sempre que identificamos um limite, criamos dois testes para ele, um para cada lado do limite (_in point_ e _out point_). Sob essa ótica, serão elaborados 4 testes, dois para cada limite (de comprimento mínimo e máximo do identificador). São eles:

- `s` vazia `""`;
- `len(s) == 1`;
- `len(s) == 6`;
- `len(s) == 7`;


## Passo 5 - Derivar os casos de teste

Idealmente, combinaríamos todas as partições que criamos para cada uma das entradas. Entretanto, para evitar a criação deliberada que tal método resultaria, consideremos os seguintes casos de teste:

## Passo 6 - Automatizar os casos de teste usando JUnit
[Descrever dificuldades ou limitações ao implementar os casos de teste]

## Passo 7 - Aumentar a suíte de testes por meio de experiência e criatividade
- testar strings com acento
- testar com caracteres especiais
    - espaço
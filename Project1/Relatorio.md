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

- Observar o caso de funcionamento trivial. A lista `left` será populada com o valor `[1]` e a lista `right` com o valor `[2]`;
    - <(`left=[1]`, `right=[2]`), (`[3]`)>

- Observar um caso com "vai um" ou _carry over_. A lista `left` receberá o valor 42, isto é, `[4, 2]` e a lista `right` o valor `[9]`;
    - <(`left=[4, 2]`, `right=[9]`), (`[5, 1]`)>

- Tomar a lista `left` como vazia, esperando que comporte-se de maneira equivalente ao número 0. Vejamos uma soma com `right` assumindo `[5, 0]`.
    - <(`left=[]`, `right=[5, 0]`), (`[5, 0]`)>


## Passo 3 - Identificar as partições

### Para cada entrada individualmente

#### Parâmetro `left`:

O argumento `left` deve ser uma lista de elementos do tipo inteiro. Além disso, cada posição da lista deve ser um dígito entre 0 a 9. Dessa forma, são estabelecidas as seguintes partições válidas e inválidas:

**Partições válidas**

- partição comum/esperada: tamanho da lista `left` sendo maior ou igual a 1 e todas as suas `i` posições sendo um dígito entre 0 e 9, isto é, `len(left) >= 1` e `left[i] >= 0 && left[i] <= 9`;

- `left` assumir o valor de uma lista vazia.

**Partições inválidas**

- uma posição da lista `left` conter mais de um dígito, isto é, um número maior que 9 (`left[i] > 9`);

- uma posição da lista `left` conter um dígito negativo (`left[i] < 0`).

- o parâmetro `left` ser passado como `null`.

<br>

#### Parâmetro `right`:

Como o parâmetro `right` também é uma lista de elementos do tipo inteiro, cuja cada posição deve ser um dígito entre 0 a 9, ou seja, idêntico ao parâmetro `left`, obtem-se as mesmas classes de equivalência já definidas:

**Partições válidas**

- partição comum/esperada: tamanho da lista `right` sendo maior ou igual a 1 e todas as suas `i` posições sendo um dígito entre 0 e 9, isto é, `len(right) >= 1` e `right[i] >= 0 && right[i] <= 9`;

- `right` assumir o valor de uma lista vazia.

**Partições inválidas**

- uma posição da lista `right` conter mais de um dígito, isto é, um número maior que 9 (`right[i] > 9`);

- uma posição da lista `right` conter um dígito negativo (`right[i] < 0`).

- o parâmetro `right` ser passado como `null`.

<br>


### Para combinações de entrada

A identificação das partições para os parâmetros `left` e `right` foi realizada com base nos requisitos estabelecidos para cada um individualmente. Para ambos os parâmetros, foram definidas partições válidas e inválidas, considerando o tamanho das listas e os valores dos dígitos em cada posição. Sob essa ótica, não foi identificada a necessidade de combinar `left` e `right` para identificar novas partições, uma vez que as condições de validade foram abordadas de forma abrangente para cada parâmetro separadamente.


### Para saídas esperadas

Investigando as possíveis saídas, nota-se que o método `add()` pode retornar uma lista de inteiros, `null`, ou ainda uma `IllegalArgumentException`. Nesse sentido, é possível considerar diferentes valores de entrada, induzindo tais saídas.

- Partição de saída válida (soma de `left` e `right`): engloba os casos em que a soma de `left` e `right` é calculada corretamente e resulta em uma lista de inteiros.

- Partição de saída nula (`null`): abrange os casos em que um dos parâmetros é `null`, levando a um resultado nulo.

- Partição de exceção (`IllegalArgumentException`): inclui os casos em que um dos dígitos de `left` ou `right` é negativo ou maior que 9, por exemplo. Gerando assim, o lançamento da exceção `IllegalArgumentException`.


## Passo 4 - Identificar os valores limites

Defeitos nos limites do domínio de entrada são comuns em sistemas de _software_. Quando cria-se partições, elas assumem valores limites próximos que “dividem” as partições equivalentes. Sempre que um valor limite é identificado, é essencial testar o que acontece com o programa quando as entradas vão de um limite para o outro. Ou seja, teste de dois pontos quando há um valor limite. Um teste é para o _in point_ , que é o ponto que está dentro da partição; e o outro teste é para o _off point_, que é o ponto mais próximo do valor limite que pertence à partição à qual o _in point_ não pertence, isto é, a outra partição.

Nessa lógica, para o método `add()` serão elaborados 8 testes de bordas, de acordo com os limites das partições. A seguir serão listados os testes com os valores limites, referindo-se a ambos os _arrays_ de inteiros simplesmente como "lista":

- `lista == null`: lista nula (_off point_);
- `len(lista) == 1`: lista unitária (_in point_);

- `lista[i] == -1`: um elemento qualquer ser negativo (_off point_);
- `lista[i] == 0`: o elemento de menor valor válido (_in point_);

- `lista[i] == 9`: o elemento de maior valor válido (_in point_);
- `lista[i] == 10`: um elemento qualquer não ser um dígito, ou seja, ser maior que 9 (_off point_).


## Passo 5 - Derivar os casos de teste

Idealmente, combinaríamos todas as partições que criamos para cada uma das entradas. Entretanto, para evitar a criação deliberada que tal método resultaria, consideremos os seguintes casos de teste:

- T01: `left == null`
- T03: `right == null`
- T02: `left == []`
- T04: `right == []`
- T05: `left == [1]`, `right == [2, 3]`: `left` contém um único dígito válido
- T06: `left == [1, 2]`, `right == [3]`: `right` contém um único dígito válido
- T07: `left == [1, 2, 3]`, `right == [4]`: `left` contém vários dígitos válidos
- T08: `left == [1]`, `right == [2, 3, 4]`: `right` contém vários dígitos válidos
- T09: `left == [10]`, `right == [1, 2, 3]`
- T10: `left == [1, 2, 3]`, `right == [-1]`


## Passo 6 - Automatizar os casos de teste usando JUnit
[Descrever dificuldades ou limitações ao implementar os casos de teste]

## Passo 7 - Aumentar a suíte de testes por meio de experiência e criatividade

Não foi possível aumentar a suíte de testes.
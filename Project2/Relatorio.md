# Trabalho Prático de Teste Baseado em Especificação e Teste Estrutural
Método ``leftPad()``

<br>

AUTHOR <br>
Gustavo Zanzin Guerreiro Martins


## Introdução

Este documento descreve o processo utilizado para derivar casos de teste para o método `leftPad()`. Para tanto, foram utilizadas as metodologias de Teste Baseado em Especificação e Teste Estrutural. O método `leftPad()` realiza o preenchimento à esquerda de uma _string_ `str` usando outra _string_ `padStr`.


O Passo 1 deste relatório consiste em compreender os requisitos da entidade a ser testada e o Passo 2 em explorar o funcionamento do programa. No entanto, como foi solicitado, para este trabalho, a implementação do método `leftPad()`, logo tanto suas especificações quanto seu funcionamento já foi compreendido. Portanto, este relatório descreverá a partir do Passo 3.


## Passo 3 - Identificar as partições

### Para cada entrada individualmente

#### Parâmetro `str`:

O argumento `str` deve ser um objeto Java do tipo _String_. É permitida a passagem de `str` com o valor de `null`. Nesse caso, entretanto, o método `leftPad()` deve retornar `null`. Dessa forma, são estabelecidas as seguintes partições válidas e inválidas:

##### Partições válidas

- partição comum/esperada: tamanho da lista `str` sendo maior ou igual a 1 e todas as suas `i` posições sendo um dígito entre 0 e 9, isto é, `len(str) >= 1` e `str[i] >= 0 && str[i] <= 9`;

- o parâmetro `str` ser passado como `null`.

- `str` assumir o valor de uma lista vazia.

##### Partições inválidas

- uma posição da lista `str` conter mais de um dígito, isto é, um número maior que 9 (`str[i] > 9`);

- uma posição da lista `str` conter um dígito negativo (`str[i] < 0`).


<br>

#### Parâmetro `padStr`:

Como o parâmetro `padStr` também é uma lista de elementos do tipo inteiro, cuja cada posição deve ser um dígito entre 0 a 9, ou seja, idêntico ao parâmetro `left`, obtem-se as mesmas classes de equivalência já definidas:

##### Partições válidas

- partição comum/esperada: tamanho da lista `padStr` sendo maior ou igual a 1 e todas as suas `i` posições sendo um dígito entre 0 e 9, isto é, `len(padStr) >= 1` e `padStr[i] >= 0 && padStr[i] <= 9`;

- `padStr` assumir o valor de uma lista vazia.

##### Partições inválidas

- uma posição da lista `padStr` conter mais de um dígito, isto é, um número maior que 9 (`padStr[i] > 9`);

- uma posição da lista `padStr` conter um dígito negativo (`padStr[i] < 0`).

- o parâmetro `padStr` ser passado como `null`.

<br>

#### Parâmetro `size`:

Como o parâmetro `size` também é uma lista de elementos do tipo inteiro, cuja cada posição deve ser um dígito entre 0 a 9, ou seja, idêntico ao parâmetro `left`, obtem-se as mesmas classes de equivalência já definidas:

##### Partições válidas

- partição comum/esperada: tamanho da lista `size` sendo maior ou igual a 1 e todas as suas `i` posições sendo um dígito entre 0 e 9, isto é, `len(size) >= 1` e `size[i] >= 0 && size[i] <= 9`;

- `size` assumir o valor de uma lista vazia.

##### Partições inválidas

- uma posição da lista `size` conter mais de um dígito, isto é, um número maior que 9 (`size[i] > 9`);

- uma posição da lista `size` conter um dígito negativo (`size[i] < 0`).

- o parâmetro `size` ser passado como `null`.



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
- T09: `left == [10]`, `right == [1, 2, 3]`: `left` contém um número maior que 9
- T10: `left == [1, 2, 3]`, `right == [-1]`: `right` contém um número negativo


## Passo 6 - Automatizar os casos de teste usando JUnit
Não houveram dificuldades significativas na automatização dos testes do método `add()`.

## Passo 7 - Aumentar a suíte de testes por meio de experiência e criatividade

Não foi possível aumentar a suíte de testes.
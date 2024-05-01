# Trabalho Prático de Teste Baseado em Especificação e Teste Estrutural
Método ``leftPad()``

<br>

AUTOR <br>
Gustavo Zanzin Guerreiro Martins


## Introdução

Este documento descreve o processo utilizado para derivar casos de teste para o método `leftPad()`. Para tanto, foram utilizadas as metodologias de Teste Baseado em Especificação e Teste Estrutural. O método `leftPad()` realiza o preenchimento à esquerda de uma _string_ `str` usando outra _string_ `padStr`.


O Passo 1 deste relatório consiste em compreender os requisitos da entidade a ser testada e o Passo 2 em explorar o funcionamento do programa. No entanto, como foi solicitado, para este trabalho, a implementação do método `leftPad()`, logo tanto suas especificações quanto seu funcionamento já foi compreendido. Portanto, este relatório descreverá a partir do Passo 3.


## Passo 3 - Identificar as partições

### Para cada entrada individualmente

#### Parâmetro `str`:

O argumento `str` deve ser um objeto Java do tipo _String_. É permitida a passagem de `str` com o valor de `null`. Nesse caso, entretanto, o método `leftPad()` deve retornar `null`. Dessa forma, são estabelecidas as seguintes partições válidas e inválidas:

##### Partições válidas

- O parâmetro `str` ser passado como `null`.
- Assumir o valor de uma _string_ vazia, ou seja, `""`.
- Tamanho da _string_ `str` sendo maior ou igual a 1, isto é, `len(str) >= 1`;
- Assumindo valores de caracteres especiais (incluindo espaço em branco).

##### Partições inválidas

Com base na especificação de requisitos e sendo o parâmetro `str` do tipo _string_ (ou seja, impossível realizar a inserção de um argumento de outro tipo), não foi possível identificar partições inválidas para `str` neste caso específico.

<br>

#### Parâmetro `padStr`:

O parâmetro `padStr` também é um objeto Java do tipo _String_. Este, no método `leftPad()`, tem como papel ser o conteúdo que preencherá a _string_ de entrada. Outrossim, quando assumir os valores `null` ou string vazia (`""`) deve ser internamente tratado como um espaço em branco, ou seja, `" "`.

Entretanto, como a especificação de requisitos foi vaga e existiu o livre arbítrio relacionado às decisões de projeto durante a implementação do método, definiu-se que não há limite de comprimento para a _string_ em questão. Nesse sentido, quando `padStr` extrapola o tamanho que deveria ter para preencher `str`, o vetor de caracteres `padStr` é truncado.

##### Partições válidas

- O parâmetro `padStr` pode ser passado como `null` ou como uma _string_ vazia, ou seja, `""`.
- Tamanho da _string_ `padStr` sendo maior ou igual a 1, isto é, `len(padStr) >= 1`;
- Assumindo valores de caracteres especiais.

##### Partições inválidas

Com base na especificação de requisitos e sendo o parâmetro `padStr` do tipo _string_ (ou seja, impossível realizar a inserção de um argumento de outro tipo), não foi possível identificar partições inválidas para `padStr` neste caso específico.

<br>

#### Parâmetro `size`:

Por outro lado, o parâmetro `size` é um número do tipo inteiro (`int`) no qual deve representar o comprimento máximo da _string_ preenchida que será retornada pelo método `leftPad()`. Dessa forma, obtem-se as seguintes classes de equivalência:

##### Partições válidas

- Representando qualquer valor maior ou igual a 0 (`size >= 0`).

##### Partições inválidas

- Assumir um valor negativo (`size < 0`).


<br>


### Para combinações de entrada

De acordo com a especificação de requisitos, também é possível identificar classes de equivalência a partir da combinação dos parâmetros de entrada. Sob essa ótica, identificou-se as seguintes partições:

- `size` maior ou igual a soma dos tamanhos de `str` e `padStr`.
- `size` menor que a soma dos tamanhos de `str` e `padStr`.
- `str` vazia e `size` maior que o comprimento de `padStr`.
- `str` vazia e `size` menor que o comprimento de `padStr`.

<br>


### Para saídas esperadas

Investigando as possíveis saídas, nota-se que o método `leftPad()` pode retornar uma _string_, `null`, ou ainda uma `Exception`. Nesse sentido, é possível considerar diferentes valores de entrada, induzindo tais saídas.

- Partição de saída válida: engloba os casos em que o preenchimento é efetuado corretamente e resulta em uma nova _string_ preenchida. Esses casos são obtidos quando tem-se:
    - `size` maior ou igual a soma dos tamanhos de `str` e `padStr`.

- Partição de saída nula (`null`): abrange o caso em que o argumento `str` é passado como `null`, levando a um resultado nulo.

- Partição de exceção (`Exception`): inclui os casos em que `size` é negativo e quando o comprimento de `str` é maior que `size`. Gerando assim, o lançamento da exceção `Exception`.


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
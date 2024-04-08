# Relatório Trabalho Prático de Teste Baseado em Especificação

<!-- #### Método para adição de números inteiros muito, muito grandes -->

Author

Gustavo Zanzin Guerreiro Martins


## Introdução

Este documento descreve o processo utilizado para derivar casos de teste para os métodos da classe `Identifier`, a saber, `validateIdentifier()`, `valid_s()` e `valid_f()`.


## Passo 1 - Compreender os requisitos da entidade a ser testada

O programa deve determinar se um identificador é ou não 
válido em '_Silly Pascal_' (uma estranha variante do Pascal).

- Um identificador válido deve começar com uma letra;
- Um identificador válido deve conter apenas letras ou dígitos;
- Um identificador válido deve ser composto por, no mínimo, 1 caractere de comprimento.
- Um identificador válido deve deve ser composto por, no máximo 6, caracteres de comprimento.

## Passo 2 - Explorar o funcionamento do programa

O processo executado foi:

- Observar um caso de funcionamento comum. Passando a string "name";
    - <(`s`="name"), (true)>
- Observar o comportamento quando um argumento `null` é inserido como parâmetro;
    - <(`s`=null), (false)>
- Verificar o comportamento quando o parâmetro de entrada é uma string vazia;
    - <(`s`=""), (false)>
- Explorar o método com uma string de entrada cujo comprimento é 6;
    - <(`s`="grande"), (true)>
- Explorar o método com uma string de entrada cujo comprimento é maior que 6;
    - <(`s`="grande123"), (false)>
- Visualizar a saída quando a entrada é uma string que inicia com um número;
    - <(`s`="1name"), (false)>


## Passo 3 - Identificar as partições

### Para cada entrada individualmente

Como no método `validateIdentifier()` existe apenas um parâmetro, ele será o único a ser analisado.

### Parâmetro `s`:

O argumento `s` pode ser qualquer _string_. A especificação diz que o identificador deve iniciar com pelo menos uma letra. Nos requisitos é também abordado o comprimento do parâmetro, a saber, mínimo 1 e máximo 6. Nesse sentido, serão verificadas as partições a seguir:

- `s` iniciando com 1 letra seguida de alguns dígitos cujo comprimento total não ultrapasse 6 caracteres (partição comum/esperada).

- apenas dígitos
    - `len(s) == 1`;
    - `len(s) >= 7`;

- apenas letras
    - `len(s) == 1`;
    - `len(s) >= 7`.
 
Além disso, os casos nulos e vazios também serão testados, porque são sempre bons casos de teste excepcionais.

- `s` vazia;
- `s` com valor `null`;

### Para combinações de entrada

Como já mencionado, o método a ser testado conta com apenas um parâmetro de entrada. Sendo assim, não é possível combinar valores diferentes em diferentes argumentos na entrada de tal método. No entanto, é possível atribuir valores variados ao parâmetro `s`.

- `s` pode conter dígitos ou não, porém não pode iniciar com dígitos.
    - `s` deve iniciar com uma letra.

### Para saídas esperadas

Investigando as possíveis saídas, nota-se que o método `validateIdentifier()` pode retornar apenas um booleano, isto é, `true` ou `false`.

## Identificar os valore limites

Defeitos nos limites do domínio de entrada são comuns em sistemas de _software_. Quando cria-se partições, elas assumem valores limites próximos que “dividem” as partições equivalentes. Sempre que um valor limite é identificado, é essencial testar o que acontece com o programa quando as entradas vão de um limite para o outro. Ou seja, teste de dois pontos quando há um valor limite. Um teste é para o _on point_ , que é o ponto que está dentro da partição; e o outro teste é para o _off point_, que é o ponto mais próximo do valor limite que pertence à partição à qual o _on point_ não pertence, isto é, a outra partição.

No caso de `validateIdentifier()`, um limite acontece quando a _string_ de entrada assume valores de comprimento de caracteres entre 1 e 7, passando (possivelmente) de uma saída `true` para `false`. Além disso, outro limite ocorre quando o primeiro caractere passa a ser um dígito ao invés de uma letra, fazendo a saída booleana ser alterada novamente.

- `len(s) == 1`;
- `len(s) == 6`;
- `len(s) == 7`;

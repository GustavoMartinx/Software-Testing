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
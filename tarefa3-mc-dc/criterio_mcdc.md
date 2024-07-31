# Critério MC/DC

- Critérios para laços:
    - Para caso ``false``
    - Para ``n == 1``
    - Para um ``n`` qualquer

- Critérios para condicionais:
    - Quando houver 1 comparação, 2 testes: ``true`` e ``false``
    - Quando houver mais de uma comparação, deverá ser seguido o passo-a-passo do exemplo:

    ```java
    if(valid_id && (s.length >= 1) && (s.length < 6))
    ```

    | Teste | `valid_id` | `s.length >= 1` | `s.length < 6` | Decisão |
    |-------|------------|-----------------|----------------|---------|
    | T1    |     T      |       T         |       T        |    T    |
    | T2    |     T      |       T         |       F        |    F    |
    | T3    |     T      |       F         |       T        |    F    |
    | T4    |     T      |       F         |       F        |    F    |
    | T5    |     F      |       T         |       T        |    F    |
    | T6    |     F      |       T         |       F        |    F    |
    | T7    |     F      |       F         |       T        |    F    |
    | T8    |     F      |       F         |       F        |    F    |
    
    <br>

    1 - Escolher uma condição para avaliar;

    2 - Encontrar um **valor** tanto de Decisão quanto da condição escolhida que sejam o inverso do inicial;

    3 - Observar, para todos esses casos, as outras condições cujos valores sejam iguais ao valor inicial;

    4 - Quando atendidas tais condições, encontra-se um par.
    
    <br>

    Para este exemplo, encontrou-se os pares:
    - valid_id:       (T1, T5)
    - s.length >= 1:  (T1, T3)
    - s.length < 6:   (T1, T2)

    Sabe-se que para N condições, derivam-se N + 1 casos de teste. Sob essa ótica, torna-se desnecessária, para este exemplo, a criação dos 8 casos testes, mas sim de apenas 4 e obtendo a mesma cobertura.

    Portanto, podemos reduzir a suíte de casos de teste necessários em:
    T1, T5, T3 e T2.



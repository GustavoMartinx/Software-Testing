# Test Driven Development (TDD)

TDD (_Test-Driven Development_) é uma prática de desenvolvimento de software em que os testes são escritos antes do código de produção. O ciclo do TDD segue três etapas principais, conhecidas como _*Red-Green-Refactor*_:

1. _Red_: Escreve-se um teste para uma nova funcionalidade, e o teste falha (cor vermelha), já que o código que satisfaz o teste ainda não foi implementado.
2. _Green_: A seguir, é implementado o código mínimo necessário para passar no teste, fazendo-o ficar verde.
3. _Refactor_: Com o teste passando, o código pode ser refatorado para melhorar sua estrutura e qualidade, mantendo os testes verdes.

TDD promove um ciclo de desenvolvimento iterativo e incremental, garantindo que o software seja sempre testado desde o início, melhorando a qualidade do código e reduzindo bugs. Um aspecto importante do TDD é que ele força os desenvolvedores a pensar sobre os requisitos e o _design_ do sistema em pequenos passos, sempre guiados pelos testes.

Além disso, TDD pode resultar em um conjunto de testes automatizados que servem como uma documentação viva do comportamento do sistema e fornecem segurança ao modificar ou adicionar novas funcionalidades.
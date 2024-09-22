# Dublês de Teste e Mocks

Dublês de Teste são objetos ou componentes criados para simular o comportamento de dependências reais em um cenário de teste, quando essas dependências são complexas, externas ou não estão disponíveis. Eles ajudam a isolar a unidade sendo testada, eliminando interferências externas. Existem vários tipos de dublês de teste, como:

- **Stub**: retorna sempre as mesmas respostas predefinidas;
- **Fake**: possui uma implementação funcional simplificada da dependência.
- **Mock**: além de simular comportamentos, valida as interações, verificando se métodos foram chamados com parâmetros corretos;
- **Spy**: monitora as interações reais com o objeto, mas ainda utiliza a implementação original;

Mocks são um tipo específico de dublê de teste que foca em verificar como a unidade em teste interage com suas dependências. Eles permitem definir comportamentos esperados e verificar se métodos específicos foram invocados com os parâmetros corretos, facilitando a validação de interações. Eles são usados quando o comportamento do objeto em teste depende de interações com outros objetos que precisam ser simulados.

## Mockito

[Mockito](https://site.mockito.org/) é um _framework_ de _mocking_ para testes em Java. Ele permite criar objetos simulados (_mocks_) de classes e interfaces, facilitando a escrita de testes unitários e o isolamento de dependências.

### Dependência

```xml
<dependencies>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.5.0</version>
        <scope>test</scope>
    </dependency>
  </dependencies>
```
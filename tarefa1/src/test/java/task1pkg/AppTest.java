package task1pkg;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

// Implementar casos de teste
// Descrever qual o objetivo deste caso de teste
// Executar p ver oq da

public class AppTest {

    // Caso de Teste 1 - O caso trivial: cujas entradas são as mais simples possíveis. Duas execuções: a) e b)
    // a) A maior estimativa na primeira posição e a menor na segunda.
    @Test
    public void testIdentifyExtremesSimple1() {

        List<Estimate> estimates = Arrays.asList(
                new Estimate("Ivo", 5),
                new Estimate("Ana", 8)
        );

        // Criando uma instância da classe PlanningPoker
        PlanningPoker planningPoker = new PlanningPoker();

        // Chamando o método identifyExtremes com a lista de estimativas
        List<String> result = planningPoker.identifyExtremes(estimates);

        // Verificando se os resultados esperados são retornados
        assertEquals(Arrays.asList("Ivo", "Ana"), result);
    }
    
    // b) A menor estimativa na primeira posição e a maior na segunda.
    @Test
    public void testIdentifyExtremesSimple2() {

        List<Estimate> estimates = Arrays.asList(
            new Estimate("Ana", 8),
            new Estimate("Ivo", 5)
        );

        // Criando uma instância da classe PlanningPoker
        PlanningPoker planningPoker = new PlanningPoker();

        // Chamando o método identifyExtremes com a lista de estimativas
        List<String> result = planningPoker.identifyExtremes(estimates);
        
        // Verificando se os resultados esperados são retornados
        assertEquals(Arrays.asList("Ivo", "Ana"), result);
    }

    // Caso de Teste 2 - O caso comum: com várias estimativas diferentes.
    @Test
    public void testIdentifyExtremesCommon() {

        List<Estimate> estimates = Arrays.asList(
                new Estimate("Dev1", 5),
                new Estimate("Dev2", 8),
                new Estimate("Dev3", 1),
                new Estimate("Dev4", 10),
                new Estimate("Dev5", 3)
        );

        // Criando uma instância da classe PlanningPoker
        PlanningPoker planningPoker = new PlanningPoker();

        // Chamando o método identifyExtremes com a lista de estimativas
        List<String> result = planningPoker.identifyExtremes(estimates);

        // Verificando se os resultados esperados são retornados
        assertEquals(Arrays.asList("Dev3", "Dev4"), result);
    }

    // Caso de Teste 3 - Vários devs e todos com a mesma estimativa.
    @Test
    public void testIdentifyExtremesSameEstimate() {

        List<Estimate> estimates = Arrays.asList(
                new Estimate("Dev1", 5),
                new Estimate("Dev2", 5),
                new Estimate("Dev3", 5)
        );

        // Criando uma instância da classe PlanningPoker
        PlanningPoker planningPoker = new PlanningPoker();

        // Chamando o método identifyExtremes com a lista de estimativas
        List<String> result = planningPoker.identifyExtremes(estimates);

        // Verificando se os resultados esperados são retornados
        assertEquals(Arrays.asList("Dev1", "Dev3"), result);
    }

    // Caso de Teste 4 - Mais de um dev estimando o mesmo menor valor.
    @Test
    public void testIdentifyExtremesSameLowestEstimate() {

        List<Estimate> estimates = Arrays.asList(
                new Estimate("Dev1", 5),
                new Estimate("Dev2", 5),
                new Estimate("Dev3", 8),
                new Estimate("Dev4", 1),
                new Estimate("Dev5", 1)
        );

        // Criando uma instância da classe PlanningPoker
        PlanningPoker planningPoker = new PlanningPoker();

        // Chamando o método identifyExtremes com a lista de estimativas
        List<String> result = planningPoker.identifyExtremes(estimates);

        // Verificando se os resultados esperados são retornados
        assertEquals(Arrays.asList("Dev4", "Dev5"), result);
    }

    // Caso de Teste 5 - Mais de um dev estimando o mesmo maior valor.
    @Test
    public void testIdentifyExtremesSameHighestEstimate() {

        List<Estimate> estimates = Arrays.asList(
                new Estimate("Dev1", 10),
                new Estimate("Dev2", 8),
                new Estimate("Dev3", 10),
                new Estimate("Dev4", 15),
                new Estimate("Dev5", 15)
        );

        // Criando uma instância da classe PlanningPoker
        PlanningPoker planningPoker = new PlanningPoker();

        // Chamando o método identifyExtremes com a lista de estimativas
        List<String> result = planningPoker.identifyExtremes(estimates);

        // Verificando se os resultados esperados são retornados
        assertEquals(Arrays.asList("Dev1", "Dev3"), result);
    }
}

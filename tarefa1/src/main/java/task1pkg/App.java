package task1pkg;

import java.util.List;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Estimate estimate1 = new Estimate("Dev1", 10.0);
        Estimate estimate2 = new Estimate("Dev2", 15.0);
        Estimate estimate3 = new Estimate("Dev3", 1.0);

        List<Estimate> estimates = Arrays.asList(estimate1, estimate2, estimate3);

        PlanningPoker planning = new PlanningPoker();

        List<String> extremes = planning.identifyExtremes(estimates);

        System.out.printf("Desenvolvedor com menor estimativa: %s, Desenvolvedor com maior estimativa: %s%n", extremes.get(0), extremes.get(1));
    }
}

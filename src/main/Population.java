package main;

import java.util.ArrayList;
import java.util.List;

public class Population {

    private IIndividual targetIndividual;
    private int populationSize;
    private List<IIndividual> individuals;

    public Population(IIndividual targetIndividual, int populationSize) {
        this.targetIndividual = targetIndividual;
        this.populationSize = populationSize;
        this.individuals = new ArrayList<>();
    }

    public Population initializePopulation(String individualType) {
        for (int i = 0; i < populationSize; i++) {
            individuals.add(IndividualFactory.createIndividual(individualType, targetIndividual.getGenes().toString()));
        }
        sortIndividualByChromosomeFitness();
        return this;
    }

    public void sortIndividualByChromosomeFitness() {
        individuals.sort((individual1, individual2) -> {
            int flag = 0;
            if (individual1.getFitness() > individual2.getFitness()) flag = -1;
            else if (individual1.getFitness() < individual2.getFitness()) flag = 1;
            return flag;
        });
    }
}

package main;

import main.individuals.IIndividual;
import main.individuals.IndividualFactory;
import main.utils.GeneticAlgorithmUtilsService;

import java.util.ArrayList;
import java.util.List;

public class Population {

    private IIndividual targetIndividual;
    private int populationSize;
    private List<IIndividual> individuals;
    private String individualType;

    public Population(IIndividual targetIndividual, int populationSize, String individualType) {
        this.targetIndividual = targetIndividual;
        this.populationSize = populationSize;
        this.individuals = new ArrayList<>();
        this.individualType = individualType;
        for (int i = 0; i < populationSize; i++) {
            individuals.add(IndividualFactory.createIndividual(individualType, GeneticAlgorithmUtilsService.targetIndividualGenesToString(targetIndividual)));
        }
        sortIndividualByChromosomeFitness();
    }

    public IIndividual getTargetIndividual() {
        return targetIndividual;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public List<IIndividual> getIndividuals() {
        return individuals;
    }

    public String getIndividualType() {
        return individualType;
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

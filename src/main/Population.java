package main;

import main.individuals.IIndividual;
import main.individuals.IndividualFactory;

import java.util.ArrayList;
import java.util.List;

public class Population {

    private IndividualFactory factory;
    private int populationSize;
    private List<IIndividual> individuals;
    private String individualType;

    public Population(IndividualFactory factory, int populationSize, String individualType) {
        this.factory = factory;
        this.populationSize = populationSize;
        this.individuals = new ArrayList<>();
        this.individualType = individualType;
        for (int i = 0; i < populationSize; i++) {
            individuals.add(factory.createIndividual());
        }
        sortIndividualByChromosomeFitness();
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

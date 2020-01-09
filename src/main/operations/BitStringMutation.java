package main.operations;

import main.Population;
import main.individuals.IIndividual;
import main.individuals.IndividualFactory;
import main.utils.GeneticAlgorithmUtilsService;


public class BitStringMutation implements IMutation {

    private Population population;
    private int numbOfEliteIndividuals;
    private double mutationRate;
    private String individualType;

    public BitStringMutation(Population population, int numbOfEliteIndividuals, double mutationRate, String individualType) {
        this.population = population;
        this.numbOfEliteIndividuals = numbOfEliteIndividuals;
        this.mutationRate = mutationRate;
        this.individualType = individualType;
    }

    @Override
    public Population execute(Population population) {
        Population mutatePopulation = new Population(population.getTargetIndividual(), population.getPopulationSize(), population.getIndividualType());
        for (int i = 0; i < numbOfEliteIndividuals; i++) {
            mutatePopulation.getIndividuals().get(i).setGenes(population.getIndividuals().get(i).getGenes());
        }
        for (int i = numbOfEliteIndividuals; i < population.getPopulationSize(); i++) {
            mutatePopulation.getIndividuals().set(i, mutateIndividualGenes(mutatePopulation.getIndividuals().get(i), individualType));
        }
        return mutatePopulation;
    }

    private IIndividual mutateIndividualGenes(IIndividual individual, String individualType) {
        IIndividual mutateIndividual = IndividualFactory.createIndividual(individualType, GeneticAlgorithmUtilsService.targetIndividualGenesToString(individual));
        for (int i = 0; i < individual.getGenes().size(); i++) {
            if (Math.random() <= mutationRate) {
                if (Math.random() <= 0.5) mutateIndividual.getGenes().set(i, 1);
                else mutateIndividual.getGenes().set(i, 0);
            } else {
                mutateIndividual.getGenes().set(i, 0);
            }
        }
        return mutateIndividual;
    }
}

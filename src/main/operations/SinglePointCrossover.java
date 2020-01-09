package main.operations;

import main.Population;
import main.individuals.IIndividual;
import main.individuals.IndividualFactory;
import main.utils.GeneticAlgorithmUtilsService;

public class SinglePointCrossover implements ICrossover {

    public Population population;
    private int numbOfEliteIndividuals;
    private double crossoverRate;
    private String individualType;
    private int tournamentSelectionSize;

    public SinglePointCrossover(Population population, int numbOfEliteIndividuals, double crossoverRate, String individualType, int tournamentSelectionSize) {
        this.population = population;
        this.numbOfEliteIndividuals = numbOfEliteIndividuals;
        this.crossoverRate = crossoverRate;
        this.individualType = individualType;
        this.tournamentSelectionSize = tournamentSelectionSize;
    }

    @Override
    public Population execute(Population population) {
        Population crossoverPopulation = new Population(population.getTargetIndividual(), population.getPopulationSize(), population.getIndividualType());
        for (int i = 0; i < numbOfEliteIndividuals; i++) {
            crossoverPopulation.getIndividuals().get(i).setGenes(population.getIndividuals().get(i).getGenes());
        }

        IIndividual individual1 = null;
        IIndividual individual2 = null;
        for (int i = numbOfEliteIndividuals; i < population.getIndividuals().size(); i++) {
            if (Math.random() <= crossoverRate) {
                individual1 = selectTournamentPopulation(population).getIndividuals().get(0);
                individual2 = selectTournamentPopulation(population).getIndividuals().get(0);
                crossoverPopulation.getIndividuals().set(i, crossoverIndividualsChromosomes(individual1, individual2, individualType));
            } else {
                crossoverPopulation.getIndividuals().set(i, selectTournamentPopulation(population).getIndividuals().get(0));
            }
        }
        return crossoverPopulation;
    }

    private Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(population.getTargetIndividual(), tournamentSelectionSize, individualType);
        for (int i = 0; i < tournamentSelectionSize; i++) {
            tournamentPopulation.getIndividuals().set(i, population.getIndividuals().get((int)(Math.random() * population.getIndividuals().size())));
        }
        tournamentPopulation.sortIndividualByChromosomeFitness();
        return tournamentPopulation;
    }

    private IIndividual crossoverIndividualsChromosomes(IIndividual individual1, IIndividual individual2, String individualType) {
        IIndividual crossoverIndividual = IndividualFactory.createIndividual(individualType, GeneticAlgorithmUtilsService.targetIndividualGenesToString(individual1));
        for (int i = 0; i < individual1.getGenes().size(); i++) {
            if (Math.random() < 0.5) crossoverIndividual.getGenes().set(i, individual1.getGenes().get(i));
            else crossoverIndividual.getGenes().set(i, individual2.getGenes().get(i));
        }
        return crossoverIndividual;
    }
}

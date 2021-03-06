package main.operations;

import main.Population;
import main.individuals.IIndividual;
import main.individuals.IndividualFactory;

public class SinglePointCrossover implements ICrossover {

    private IndividualFactory factory;
    public Population population;
    private int numbOfEliteIndividuals;
    private double crossoverRate;
    private String individualType;
    private int tournamentSelectionSize;

    public SinglePointCrossover(IndividualFactory factory, Population population, int numbOfEliteIndividuals, double crossoverRate, String individualType, int tournamentSelectionSize) {
        this.factory = factory;
        this.population = population;
        this.numbOfEliteIndividuals = numbOfEliteIndividuals;
        this.crossoverRate = crossoverRate;
        this.individualType = individualType;
        this.tournamentSelectionSize = tournamentSelectionSize;
    }

    @Override
    public Population execute(Population population) {
        Population crossoverPopulation = new Population(factory, population.getPopulationSize(), population.getIndividualType());
        for (int i = 0; i < numbOfEliteIndividuals; i++) {
            crossoverPopulation.setIndividual(i, population.getIndividual(i));
        }
        IIndividual individual1 = null;
        IIndividual individual2 = null;
        for (int i = numbOfEliteIndividuals; i < population.getPopulationSize(); i++) {
            if (Math.random() <= crossoverRate) {
                individual1 = selectTournamentPopulation(population).getIndividual(0);
                individual2 = selectTournamentPopulation(population).getIndividual(0);
                crossoverPopulation.setIndividual(i, crossoverIndividualsChromosomes(individual1, individual2));
            } else {
                crossoverPopulation.setIndividual(i, selectTournamentPopulation(population).getIndividual(0));
            }
        }

        crossoverPopulation.sortIndividualByChromosomeFitness();
        return crossoverPopulation;
    }

    private Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(factory, tournamentSelectionSize, individualType);
        for (int i = 0; i < tournamentSelectionSize; i++) {
            tournamentPopulation.setIndividual(i, population.getIndividual((int) (Math.random() * population.getIndividuals().size())));
        }
        tournamentPopulation.sortIndividualByChromosomeFitness();
        return tournamentPopulation;
    }

    private IIndividual crossoverIndividualsChromosomes(IIndividual individual1, IIndividual individual2) {
        IIndividual crossoverIndividual = factory.createIndividual();
        for (int i = 0; i < individual1.getGenes().size(); i++) {
            if (Math.random() < 0.5) crossoverIndividual.setGene(i, individual1.getGene(i));
            else crossoverIndividual.setGene(i, individual2.getGene(i));
        }
        return crossoverIndividual;
    }
}

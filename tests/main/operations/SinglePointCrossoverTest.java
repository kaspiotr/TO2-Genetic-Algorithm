package main.operations;

import main.Population;
import main.individuals.IIndividual;
import main.individuals.IndividualFactory;
import org.junit.Test;


import static org.junit.Assert.*;

public class SinglePointCrossoverTest {


    private IIndividual crossoverIndividualsChromosomes(IndividualFactory factory, IIndividual individual1, IIndividual individual2) {
        IIndividual crossoverIndividual = factory.createIndividual();
        for (int i = 0; i < individual1.getGenes().size(); i++) {
            if (Math.random() < 0.5) crossoverIndividual.setGene(i, individual1.getGene(i));
            else crossoverIndividual.setGene(i, individual2.getGene(i));
        }
        return crossoverIndividual;
    }

    private Population selectTournamentPopulation(IndividualFactory factory, int tournamentSelectionSize, String individualType, Population population) {
        Population tournamentPopulation = new Population(factory, tournamentSelectionSize, individualType);
        for (int i = 0; i < tournamentSelectionSize; i++) {
            tournamentPopulation.setIndividual(i, population.getIndividual((int) (Math.random() * population.getIndividuals().size())));
        }
        tournamentPopulation.sortIndividualByChromosomeFitness();
        return tournamentPopulation;
    }

    @Test
    public void execute() {
        String integerIndividualType = "Integer";
        String integerGenesString = "1,1,1,1,0,0,0,0";
        IndividualFactory factory = new IndividualFactory(integerIndividualType, integerGenesString);
        Population populationToCrossover = new Population(factory, 10, integerGenesString);
        Population crossoveredPopulation = new Population(factory, populationToCrossover.getPopulationSize(), populationToCrossover.getIndividualType());
        int numbOfEliteIndividuals = 2;
        for (int i = 0; i < numbOfEliteIndividuals; i++) {
            crossoveredPopulation.setIndividual(i, populationToCrossover.getIndividual(i));
        }
        IIndividual individual1 = null;
        IIndividual individual2 = null;
        double crossoverRate = 0.2;
        int tournamentSelectionSize = 3;
        for (int i = numbOfEliteIndividuals; i < populationToCrossover.getPopulationSize(); i++) {
            if (Math.random() <= crossoverRate) {
                individual1 = selectTournamentPopulation(factory, tournamentSelectionSize, integerIndividualType, populationToCrossover).getIndividual(0);
                individual2 = selectTournamentPopulation(factory, tournamentSelectionSize, integerIndividualType, populationToCrossover).getIndividual(0);
                crossoveredPopulation.setIndividual(i, crossoverIndividualsChromosomes(factory, individual1, individual2));
            } else {
                crossoveredPopulation.setIndividual(i, selectTournamentPopulation(factory, tournamentSelectionSize, integerIndividualType, populationToCrossover).getIndividual(0));
            }
        }

        //when
        Population actualPopulationAfterCrossover = new SinglePointCrossover(factory, populationToCrossover, numbOfEliteIndividuals, crossoverRate, "Integer", tournamentSelectionSize).execute(populationToCrossover);
        Population expectedPopulationAfterCrossover = crossoveredPopulation;

        //then
        assertNotEquals(actualPopulationAfterCrossover, expectedPopulationAfterCrossover);
    }
}
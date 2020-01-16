package tests;

import main.Population;
import main.individuals.IIndividual;
import main.individuals.IndividualFactory;
import main.operations.BitStringMutation;
import org.junit.Test;

import static org.junit.Assert.*;

public class BitStringMutationTest {

    @Test
    public void execute() {
        String integerIndividualType = "Integer";
        String integerGenesString = "1,1,1,1,0,0,0,0";
        IndividualFactory factory = new IndividualFactory(integerIndividualType, integerGenesString);
        Population populationToMutate = new Population(factory, 10, integerIndividualType);
        Population mutatedPopulation = new Population(factory, populationToMutate.getPopulationSize(), populationToMutate.getIndividualType());
        int numbOfEliteIndividuals = 2;
        for (int i = 0; i < numbOfEliteIndividuals; i++) {
            mutatedPopulation.setIndividual(i, populationToMutate.getIndividual(i));
        }
        double mutationRate = 0.2;
        for (int i = numbOfEliteIndividuals; i < populationToMutate.getPopulationSize(); i++) {
            //mutateIndividualGenes method
            IIndividual mutatedIndividual = factory.createIndividual();
            for (int x = 0; x < populationToMutate.getIndividual(i).getGenes().size(); x++) {
                if (Math.random() <= mutationRate) {
                    if (Math.random() < 0.5) mutatedIndividual.setGene(x,  1);
                    else mutatedIndividual.setGene(x, 0);
                } else {
                    mutatedIndividual.setGene(x, populationToMutate.getIndividual(i).getGene(x));
                }
            }
            //
            mutatedPopulation.setIndividual(i, mutatedIndividual);
        }
        //when
        Population actualPopulationAfterMutation = new BitStringMutation(factory, populationToMutate, numbOfEliteIndividuals, mutationRate, "Integer").execute(populationToMutate);
        Population expectedPopulationAfterMutation = mutatedPopulation;

        //then
        assertNotEquals(actualPopulationAfterMutation, expectedPopulationAfterMutation);
        assertEquals(actualPopulationAfterMutation.getIndividual(0), expectedPopulationAfterMutation.getIndividual(0));
        assertEquals(actualPopulationAfterMutation.getIndividual(1), expectedPopulationAfterMutation.getIndividual(1));
        assertNotEquals(actualPopulationAfterMutation.getIndividual(2), expectedPopulationAfterMutation.getIndividual(2));
        assertNotEquals(actualPopulationAfterMutation.getIndividual(2), expectedPopulationAfterMutation.getIndividual(3));
        assertNotEquals(actualPopulationAfterMutation.getIndividual(2), expectedPopulationAfterMutation.getIndividual(4));
        assertNotEquals(actualPopulationAfterMutation.getIndividual(2), expectedPopulationAfterMutation.getIndividual(5));
    }
}
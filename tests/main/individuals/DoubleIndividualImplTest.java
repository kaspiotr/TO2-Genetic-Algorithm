package main.individuals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DoubleIndividualImplTest {
    private IIndividual targetFactory(int amount) {
        ArrayList<Double> genes = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            genes.add(1.0);
        }

        return new DoubleIndividualImpl(genes);
    }

    @Test
    public void getProperFitnessValue() {
        IIndividual target = targetFactory(4);
        List<Double> genesLow = new ArrayList<>();
        genesLow.add(0.5);
        genesLow.add(0.5);
        genesLow.add(0.5);
        genesLow.add(0.5);

        List<Double> genesMedium = new ArrayList<>();
        genesMedium.add(0.5);
        genesMedium.add(0.98);
        genesMedium.add(1.04);
        genesMedium.add(0.5);

        List<Double> genesMax = new ArrayList<>();
        genesMax.add(1.0);
        genesMax.add(0.99);
        genesMax.add(1.02);
        genesMax.add(1.04);

        DoubleIndividualImpl implLow = new DoubleIndividualImpl(target, genesLow);
        DoubleIndividualImpl implMedium = new DoubleIndividualImpl(target, genesMedium);
        DoubleIndividualImpl implMax = new DoubleIndividualImpl(target, genesMax);

        assertEquals(0, implLow.getFitness());
        assertEquals(2, implMedium.getFitness());
        assertEquals(4, implMax.getFitness());
    }
}
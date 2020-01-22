package main.individuals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryIndividualImplTest {

    private BinaryIndividualImpl targetFactory(int amount) {
        ArrayList<Integer> genes = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            genes.add(1);
        }

        return new BinaryIndividualImpl(genes);
    }

    @Test
    public void getProperFitnessValue() {
        IIndividual target = targetFactory(4);
        List<Integer> genesLow = new ArrayList<>();
        genesLow.add(0);
        genesLow.add(0);
        genesLow.add(0);
        genesLow.add(0);

        List<Integer> genesMedium = new ArrayList<>();
        genesMedium.add(0);
        genesMedium.add(1);
        genesMedium.add(1);
        genesMedium.add(0);

        List<Integer> genesMax = new ArrayList<>();
        genesMax.add(1);
        genesMax.add(1);
        genesMax.add(1);
        genesMax.add(1);

        BinaryIndividualImpl implLow = new BinaryIndividualImpl(target, genesLow);
        BinaryIndividualImpl implMedium = new BinaryIndividualImpl(target, genesMedium);
        BinaryIndividualImpl implMax = new BinaryIndividualImpl(target, genesMax);

        assertEquals(0, implLow.getFitness());
        assertEquals(2, implMedium.getFitness());
        assertEquals(4, implMax.getFitness());
    }
}
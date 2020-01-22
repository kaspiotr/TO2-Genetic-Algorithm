package main.individuals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CharIndividualImplTest {
    private CharIndividualImpl targetFactory(int amount) {
        List<Character> genes = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            genes.add('a');
        }

        return new CharIndividualImpl(genes);
    }

    @Test
    public void getProperFitnessValue() {
        IIndividual target = targetFactory(4);
        List<Character> genesLow = new ArrayList<>();
        genesLow.add('z');
        genesLow.add('z');
        genesLow.add('z');
        genesLow.add('z');

        List<Character> genesMedium = new ArrayList<>();
        genesMedium.add('z');
        genesMedium.add('c');
        genesMedium.add('a');
        genesMedium.add('a');

        List<Character> genesMax = new ArrayList<>();
        genesMax.add('a');
        genesMax.add('a');
        genesMax.add('a');
        genesMax.add('a');

        CharIndividualImpl implLow = new CharIndividualImpl(target, genesLow);
        CharIndividualImpl implMedium = new CharIndividualImpl(target, genesMedium);
        CharIndividualImpl implMax = new CharIndividualImpl(target, genesMax);

        assertEquals(0, implLow.getFitness());
        assertEquals(2, implMedium.getFitness());
        assertEquals(4, implMax.getFitness());
    }
}
package main.individuals;

import java.util.List;
import java.util.Random;

public class DoubleIndividualImpl extends AbstractIndividual<Double> {

    public DoubleIndividualImpl(List<Double> targetIndividualGenes) {
        super(targetIndividualGenes);
        for (int i = 0; i < chromosomeSize; i++) {
            genes.add(i, new Random().nextDouble());
        }
    }

}

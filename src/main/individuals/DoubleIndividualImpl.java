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

    @Override
    public int getFitness() {
        int similarity = 0;
        System.out.println(similarity);
        for (int i = 0; i < genes.size(); i++) {
            double a = genes.get(i);
            double b = targetIndividualGenes.get(i);
            if (Math.abs(a - b) < 0.1)
                similarity++;
        }
        return similarity;
    }


}

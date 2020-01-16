package main.individuals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoubleIndividualImpl extends AbstractIndividual<Double> {

    public DoubleIndividualImpl(List<Double> genes) {
        super(genes);
        targetIndividual = this;
    }

    public DoubleIndividualImpl(IIndividual targetIndividual) {
        super();
        genes = new ArrayList<>();
        this.targetIndividual = targetIndividual;
        for (int i = 0; i < targetIndividual.getGenes().size(); i++) {
            genes.add(i, new Double(new Random().nextDouble()));
        }
    }

    @Override
    public int getFitness() {
        int similarity = 0;
        for (int i = 0; i < genes.size(); i++) {
            double a = genes.get(i);
            double b = (double) targetIndividual.getGene(i);
            if (Math.abs(a - b) < 0.05)
                similarity++;
        }
        return similarity;
    }

}

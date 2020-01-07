package main;

import java.util.List;
import java.util.Random;

public class DoubleIndividualImpl extends AbstractIndividual<Double> {

    public DoubleIndividualImpl(List<Double> genes) {
        super(genes);
    }

    @Override
    public IIndividual initializeIndividual() {
        for (int i = 0; i < genes.size(); i++) {
            genes.add(i, new Random().nextDouble());
        }
        return this;
    }


}

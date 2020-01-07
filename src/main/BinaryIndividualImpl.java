package main;

import java.util.List;

public class BinaryIndividualImpl extends AbstractIndividual<Integer>{

    public BinaryIndividualImpl(List<Integer> genes) {
        super(genes);
    }

    public BinaryIndividualImpl initializeIndividual() {
        for (int i = 0; i < genes.size(); i++) {
            if (Math.random() >= 0.5) genes.add(i, 1);
            else genes.add(i, 0);
        }
        return this;
    }
}

package main.individuals;

import java.util.List;

public class BinaryIndividualImpl extends AbstractIndividual<Integer>{

    public BinaryIndividualImpl(List<Integer> targetIndividualGenes) {
        super(targetIndividualGenes);
        for (int i = 0; i < chromosomeSize; i++) {
            if (Math.random() >= 0.5) genes.add(i, 1);
            else genes.add(i, 0);
        }
    }

    @Override
    public List<Integer> getGenes() {
        return super.getGenes();
    }

    @Override
    public void setGenes(List<Integer> genes) {
        super.setGenes(genes);
    }
}

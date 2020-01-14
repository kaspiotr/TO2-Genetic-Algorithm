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
    public int getFitness() {
        int individualFitness = 0;
        for (int i = 0; i < genes.size(); i++) {
            if (genes.get(i) == targetIndividualGenes.get(i))
                individualFitness++;
        }
        System.out.println(individualFitness);
        return individualFitness;
    }

}

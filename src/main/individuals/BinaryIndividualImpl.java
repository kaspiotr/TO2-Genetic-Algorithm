package main.individuals;

import java.util.ArrayList;
import java.util.List;

public class BinaryIndividualImpl extends AbstractIndividual<Integer>{

    public BinaryIndividualImpl(List<Integer> genes) {
        super(genes);
        targetIndividual = this;
    }

    public BinaryIndividualImpl(IIndividual targetIndividual) {
        super();
        genes = new ArrayList<>();

        this.targetIndividual = targetIndividual;

        for(int i=0;i<targetIndividual.getGenes().size();i++){
            if (Math.random() >= 0.5) genes.add(i, 1);
            else genes.add(i, 0);
        }
    }

    @Override
    public int getFitness() {
        int individualFitness = 0;
        for (int i = 0; i < targetIndividual.getGenes().size(); i++) {
            if (genes.get(i) == targetIndividual.getGene(i))
                individualFitness++;
        }

        return individualFitness;
    }

}

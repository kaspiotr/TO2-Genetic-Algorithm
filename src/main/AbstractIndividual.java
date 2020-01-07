package main;

import java.util.List;

public class AbstractIndividual<T> implements IIndividual<T> {

    protected int fitness = 0;
    protected List<T> genes;

    public AbstractIndividual(List<T> genes) {
        this.genes = genes;
    }

    @Override
    public IIndividual initializeIndividual() {
        return null;
    }

    @Override
    public List<T> getGenes() {
        return null;
    }

    @Override
    public int getFitness() {
        return 0;
    }
}

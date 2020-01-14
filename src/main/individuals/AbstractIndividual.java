package main.individuals;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIndividual<T> implements IIndividual<T> {

    protected boolean isFitnessChanged = true;
    protected int targetIndividualFitness;
    protected List<T> targetIndividualGenes;
    protected List<T> genes;
    protected int chromosomeSize;

    public AbstractIndividual(List<T> targetIndividualGenes) {
        this.genes = new ArrayList<>();
        this.targetIndividualGenes = targetIndividualGenes;
        this.chromosomeSize = targetIndividualGenes.size();
        this.targetIndividualFitness = getTargetIndividualGenes().size();
    }


    @Override
    public List<T> getGenes() {
        isFitnessChanged = true;
        return genes;
    }

    @Override
    public List<T> getTargetIndividualGenes() {
        return targetIndividualGenes;
    }

    @Override
    public abstract int getFitness();


    @Override
    public void setGenes(List<T> genes) {
        this.genes = genes;
    }


}

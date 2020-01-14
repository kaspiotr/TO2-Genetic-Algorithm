package main.individuals;

import java.util.ArrayList;
import java.util.List;

public class AbstractIndividual<T> implements IIndividual<T> {

    protected int fitness = 0;
    protected boolean isFitnessChanged = true;
    protected List<T> targetIndividualGenes;
    protected List<T> genes;
    protected int chromosomeSize;

    public AbstractIndividual(List<T> targetIndividualGenes) {
        this.genes = new ArrayList<>();
        this.targetIndividualGenes = targetIndividualGenes;
        this.chromosomeSize = targetIndividualGenes.size();
    }

    @Override
    public void setFitness(int fitnessLevel) {
        this.fitness = fitnessLevel;
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
    public void setGenes(List<T> genes) {
        this.genes = genes;
    }

    @Override
    public int getFitness() {
        return fitness;
    }
}

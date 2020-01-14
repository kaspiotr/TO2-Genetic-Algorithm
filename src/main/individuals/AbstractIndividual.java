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
        if (isFitnessChanged) {
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    @Override
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    @Override
    public int recalculateFitness() {
        int individualFitness = 0;
        for (int i = 0; i < genes.size(); i++) {
            if (genes.get(i) == targetIndividualGenes.get(i))
                individualFitness++;
        }
        return individualFitness;
    }

}

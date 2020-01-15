package main.individuals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractIndividual<T> implements IIndividual<T> {


    protected List<T> targetIndividualGenes;
    protected List<T> genes;

    public AbstractIndividual(List<T> targetIndividualGenes) {
        this.genes = new ArrayList<>();
        this.targetIndividualGenes = targetIndividualGenes;
    }

    @Override
    public T getGene(int index) {
        return genes.get(index);
    }

    @Override
    public void setGene(int index, T gene) {
        genes.set(index, (T) gene);
    }


    @Override
    public List<T> getTargetIndividualGenes() {
        return targetIndividualGenes;
    }

    @Override
    public List<T> getGenes() {
        return genes;
    }

    @Override
    public void setGenes(List<T> newgenes) {
        genes=new ArrayList<>();
        for (int i = 0; i < newgenes.size(); i++) {
            genes.add(newgenes.get(i));
        }
    }

    @Override
    public String toString(){
        return genes.stream().map(Object::toString).collect(Collectors.joining(", "));
    }


    @Override
    public abstract int getFitness();



}

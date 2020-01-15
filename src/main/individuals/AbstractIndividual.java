package main.individuals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractIndividual<T> implements IIndividual<T> {


    protected List<T> genes;
    protected IIndividual targetIndividual;

    public AbstractIndividual(List<T> genes) {
        this.genes = genes;
    }

    public AbstractIndividual() {
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
    public List<T> getGenes() {
        return genes;
    }


    @Override
    public String toString(){
        return genes.stream().map(Object::toString).collect(Collectors.joining(", "));
    }


    @Override
    public abstract int getFitness();



}

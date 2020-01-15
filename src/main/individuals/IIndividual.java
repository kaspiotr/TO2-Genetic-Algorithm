package main.individuals;

import java.util.ArrayList;
import java.util.List;

public interface IIndividual<T> {

    List<T> getGenes();

    T getGene(int index);

    void setGene(int index, T gene);

    int getFitness();

}

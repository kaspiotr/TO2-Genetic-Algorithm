package main.individuals;

import java.util.List;

public interface IIndividual<T> {

    void setGenes(List<T> genes);

    List<T> getGenes();

    int getFitness();

    int recalculateFitness();
}

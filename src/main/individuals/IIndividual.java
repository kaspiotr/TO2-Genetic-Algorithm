package main.individuals;

import java.util.List;

public interface IIndividual<T> {

    void setGenes(List<T> genes);

    List<T> getGenes();

    List<T> getTargetIndividualGenes();

    int getFitness();

    void setFitness(int fitnessLevel);

    int recalculateFitness();
}

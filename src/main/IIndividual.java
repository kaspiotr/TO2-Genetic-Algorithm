package main;

import java.util.List;

public interface IIndividual<T> {

    IIndividual initializeIndividual();

    List<T> getGenes();

    int getFitness();
}

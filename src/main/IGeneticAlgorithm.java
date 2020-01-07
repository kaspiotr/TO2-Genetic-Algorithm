package main;

import java.util.LinkedList;

public interface IGeneticAlgorithm {

    Population initialize();

    Population evaluateFitness(Population population);

    Population createGeneration(LinkedList<IOperation> operations);

    boolean terminationCondition(Population population);

}

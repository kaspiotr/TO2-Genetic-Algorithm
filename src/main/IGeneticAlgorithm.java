package main;

import main.operations.IOperation;

import java.util.List;

public interface IGeneticAlgorithm {

    Population createGeneration(Population population, List<IOperation> operations);


    boolean terminationCondition(Population population);

}

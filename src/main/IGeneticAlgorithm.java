package main;

import main.operations.IOperation;

import java.util.List;

public interface IGeneticAlgorithm {

    Population createGeneration(List<IOperation> operations);

    boolean terminationCondition(Population population);

}

package main;

import main.individuals.IIndividual;
import main.operations.IOperation;

import java.util.List;

public class GeneticAlgorithm implements IGeneticAlgorithm {

    protected IIndividual targetSolution;
    protected double crossoverRate;
    protected double mutationRate;
    protected int numbOfEliteIndividuals;
    protected int tournamentSelectionSize;
    protected Population population;

    public GeneticAlgorithm(IIndividual targetSolution, double crossoverRate, double mutationRate, int numbOfEliteIndividuals, int tournamentSelectionSize, Population population) {
        this.targetSolution = targetSolution;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.numbOfEliteIndividuals = numbOfEliteIndividuals;
        this.tournamentSelectionSize = tournamentSelectionSize;
        this.population = population;
    }

    public int getNumbOfEliteIndividuals() {
        return numbOfEliteIndividuals;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public int getTournamentSelectionSize() {
        return tournamentSelectionSize;
    }

    @Override
    public Population createGeneration(Population population, List<IOperation> operations) {
        operations.forEach(operation -> {
            this.population = operation.execute(population);
        });
        return this.population;
    }

    @Override
    public Population evaluateFitness(Population population) {
        return null;
    }

    @Override
    public boolean terminationCondition(Population population) {
        return false;
    }
}

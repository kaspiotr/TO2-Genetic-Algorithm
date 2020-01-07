package main;

public class GeneticAlgorithm {

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
}

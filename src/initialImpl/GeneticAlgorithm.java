public class GeneticAlgorithm {

    private int[] targetSolution;
    private double crossoverRate;
    private double mutationRate;
    private int numbOfEliteChromosomes;
    private int tournamentSelectionSize;

    public GeneticAlgorithm(int[] targetSolution, double crossoverRate, double mutationRate, int numbOfEliteChromosomes, int tournamentSelectionSize) {
        this.targetSolution = targetSolution;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.numbOfEliteChromosomes = numbOfEliteChromosomes;
        this.tournamentSelectionSize = tournamentSelectionSize;
    }

    public int[] getTargetSolution() {
        return targetSolution;
    }

}

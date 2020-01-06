package initialImpl;

import javax.print.DocFlavor;

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

    public Population evolve(Population population) {
        return mutatePopulation(crossoverPopulation(population));
    }

    private Population crossoverPopulation(Population population) {
        Population crossoverPopulation = new Population(population.getChromosomes().length, this);
        for (int x = 0; x < numbOfEliteChromosomes; x++) {
            crossoverPopulation.getChromosomes()[x] = population.getChromosomes()[x];
        }
        Chromosome chromosome1 = null;
        Chromosome chromosome2 = null;
        for (int x = numbOfEliteChromosomes; x < population.getChromosomes().length; x++) {
            if (Math.random() <= crossoverRate) {
                chromosome1 = selectTournamentPopulation(population).getChromosomes()[0];
                chromosome2 = selectTournamentPopulation(population).getChromosomes()[0];
                crossoverPopulation.getChromosomes()[x] = crossoverChromosome(chromosome1, chromosome2);
            } else {
                crossoverPopulation.getChromosomes()[x] = selectTournamentPopulation(population).getChromosomes()[0];
            }
        }
        return crossoverPopulation;
    }

    private Population mutatePopulation(Population population) {
        Population mutatePopulation = new Population(population.getChromosomes().length, this);
        for (int x = 0; x < numbOfEliteChromosomes; x++) {
            mutatePopulation.getChromosomes()[x] = population.getChromosomes()[x];
        }
        for (int x = numbOfEliteChromosomes; x < population.getChromosomes().length; x++) {
            mutatePopulation.getChromosomes()[x] = mutateChromosome(population.getChromosomes()[x]);
        }
        return mutatePopulation;
    }

    public int[] getTargetChromosomeGenes() {
        return targetSolution;
    }

    private Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chromosome2) {
        Chromosome crossoverChromosome = new Chromosome(this);
        for (int x = 0; x < chromosome1.getGenes().length; x++) {
            if (Math.random() < 0.5) crossoverChromosome.getGenes()[x] = chromosome1.getGenes()[x];
            else crossoverChromosome.getGenes()[x] = chromosome2.getGenes()[x];
        }
        return crossoverChromosome;
    }

    private Chromosome mutateChromosome(Chromosome chromosome) {
        Chromosome mutateChromosome = new Chromosome(this);
        for (int x = 0; x < chromosome.getGenes().length; x++) {
            if (Math.random() <= mutationRate) {
                if (Math.random() < 0.5) mutateChromosome.getGenes()[x] = 1;
                else mutateChromosome.getGenes()[x] = 0;
            } else {
                mutateChromosome.getGenes()[x] = chromosome.getGenes()[x];
            }
        }
        return mutateChromosome;
    }

    private Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(tournamentSelectionSize, this);
        for (int x = 0; x < tournamentSelectionSize; x++) {
            tournamentPopulation.getChromosomes()[x] = population.getChromosomes()[(int)(Math.random()*population.getChromosomes().length)];
        }
        tournamentPopulation.sortChromosomesByFitness();
        return tournamentPopulation;
    }

}

package initialImpl;

import java.util.Arrays;

public class Chromosome {

    private int fitness = 0;
    private boolean isFitnessChanged = true;
    private int[] genes;
    private GeneticAlgorithm geneticAlgorithm;

    public Chromosome(GeneticAlgorithm geneticAlgorithm) {
        genes = new int[geneticAlgorithm.getTargetChromosomeGenes().length];
        this.geneticAlgorithm = geneticAlgorithm;
    }

    public Chromosome initializeChromosome() {
        for (int x = 0; x < genes.length; x++) {
            if (Math.random() >= 0.5) genes[x] = 1;
            else genes[x] = 0;
        }
        return this;
    }

    public int[] getGenes() {
        isFitnessChanged = true;
        return genes;
    }

    public int getFitness() {
        if (isFitnessChanged) {
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    public int recalculateFitness() {
        int chromosomeFitness = 0;
        for (int x=0; x < genes.length; x++) {
            if (genes[x] == geneticAlgorithm.getTargetChromosomeGenes()[x]) chromosomeFitness++;
        }
        return chromosomeFitness;
    }

    public String toString() {
        return Arrays.toString(this.genes);
    }

}

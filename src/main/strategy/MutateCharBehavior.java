package main.strategy;

import main.individuals.IndividualFactory;
import main.individuals.IIndividual;

import java.util.Random;

public class MutateCharBehavior extends IMutateBehavior {
    public MutateCharBehavior(IndividualFactory factory, double mutationRate) {
        super(factory, mutationRate);
    }

    @Override
    public IIndividual mutateIndividual(IIndividual individual) {
        String alphabet = "ABCDEFGHIJKLMNOPRSTUVWYZ";
        IIndividual mutateIndividual = factory.createIndividual();
        for (int x = 0; x < individual.getGenes().size(); x++) {
            if (Math.random() <= mutationRate) {
                Character randomChar = alphabet.charAt(new Random().nextInt(alphabet.length()));
                mutateIndividual.getGenes().set(x,  randomChar);
            } else {
                mutateIndividual.getGenes().set(x, individual.getGenes().get(x));
            }
        }
        return mutateIndividual;
    }
}

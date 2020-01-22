package main.strategy;

import main.individuals.IndividualFactory;
import main.individuals.IIndividual;

public class MutateIntegerBehavior extends IMutateBehavior{
    public MutateIntegerBehavior(IndividualFactory factory, double mutationRate) {
        super(factory, mutationRate);
    }

    @Override
    public IIndividual mutateIndividualGenes(IIndividual individual) {
        IIndividual mutateIndividual = factory.createIndividual();

        for (int x = 0; x < individual.getGenes().size(); x++) {
            if (Math.random() <= mutationRate) {
                if (Math.random() < 0.5) mutateIndividual.setGene(x,  1);
                else mutateIndividual.setGene(x, 0);
            } else {
                mutateIndividual.setGene(x, individual.getGene(x));
            }
        }

        return mutateIndividual;
    }

}

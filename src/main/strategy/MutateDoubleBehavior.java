package main.strategy;

import main.individuals.IndividualFactory;
import main.individuals.IIndividual;

public class MutateDoubleBehavior extends IMutateBehavior{


    public MutateDoubleBehavior(IndividualFactory factory, double mutationRate) {
        super(factory, mutationRate);
    }

    @Override
    public IIndividual mutateIndividual(IIndividual individual) {
        IIndividual mutateIndividual = factory.createIndividual();
        for (int x = 0; x < individual.getGenes().size(); x++) {
            if (Math.random() <= mutationRate) {
                mutateIndividual.getGenes().set(x,  Math.random());
            } else {
                mutateIndividual.getGenes().set(x, individual.getGenes().get(x));
            }
        }
        return mutateIndividual;
    }
}

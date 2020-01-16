package main.strategy;

import main.individuals.IndividualFactory;
import main.individuals.IIndividual;

public class MutateDoubleBehavior extends IMutateBehavior{


    public MutateDoubleBehavior(IndividualFactory factory, double mutationRate) {
        super(factory, mutationRate);
    }

    @Override
    public IIndividual mutateIndividualGenes(IIndividual individual) {
        IIndividual mutateIndividual = factory.createIndividual();
        for (int x = 0; x < individual.getGenes().size(); x++) {
            if (Math.random() <= mutationRate) {
                mutateIndividual.setGene(x,  Math.random());
            } else {
                mutateIndividual.setGene(x, individual.getGene(x));
            }
        }
        return mutateIndividual;
    }

}

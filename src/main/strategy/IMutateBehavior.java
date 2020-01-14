package main.strategy;

import main.individuals.IndividualFactory;
import main.individuals.IIndividual;

public abstract class IMutateBehavior {
    IndividualFactory factory;
    protected double mutationRate;

    public IMutateBehavior(IndividualFactory factory, double mutationRate) {
        this.factory = factory;
        this.mutationRate = mutationRate;
    }

    public abstract IIndividual mutateIndividual(IIndividual individual);
}

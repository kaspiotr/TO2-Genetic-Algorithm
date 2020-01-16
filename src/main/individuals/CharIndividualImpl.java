package main.individuals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharIndividualImpl extends AbstractIndividual<Character> {

    public CharIndividualImpl(List<Character> genes) {
        super(genes);
        targetIndividual = this;
    }

    public CharIndividualImpl(IIndividual targetIndividual) {
        super();
        genes = new ArrayList<>();
        this.targetIndividual = targetIndividual;
        String alphabet = "ABCDEFGHIJKLMNOPRSTUVWYZ";
        for (int i = 0; i < targetIndividual.getGenes().size(); i++) {
            genes.add(i, alphabet.charAt(new Random().nextInt(alphabet.length())));
        }
    }

    @Override
    public int getFitness() {
        int similarity = 0;
        for (int i = 0; i < targetIndividual.getGenes().size(); i++) {
            if ((genes.get(i)).equals(targetIndividual.getGene(i))){
                similarity++;
            }
        }
        return similarity;
    }

}

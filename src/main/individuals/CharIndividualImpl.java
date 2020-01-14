package main.individuals;

import java.util.List;
import java.util.Random;

public class CharIndividualImpl extends AbstractIndividual<Character> {

    public CharIndividualImpl(List<Character> targetIndividualGenes) {
        super(targetIndividualGenes);
        String alphabet = "ABCDEFGHIJKLMNOPRSTUVWYZ";
        for (int i = 0; i < chromosomeSize; i++) {
            genes.add(i, alphabet.charAt(new Random().nextInt(alphabet.length())));
        }
    }

    @Override
    public int getFitness() {
        int similarity = 0;

        for (int i = 0; i < genes.size(); i++) {
            if ((genes.get(i)).equals(targetIndividualGenes.get(i))) {
                similarity++;
            }

        }
        System.out.println(similarity);
        return similarity;
    }


}

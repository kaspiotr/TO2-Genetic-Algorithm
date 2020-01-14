package main.individuals;

import main.utils.GeneticAlgorithmUtilsService;

public class IndividualFactory {

   private String targetIndividualType;
   private String genesString;
   private IIndividual targetIndividual;

    public IndividualFactory(String individualType, String genesString) {
        this.targetIndividualType = individualType;
        this.genesString = genesString;
        switch (individualType) {
            case "Integer":
                this.targetIndividual = new BinaryIndividualImpl(GeneticAlgorithmUtilsService.getBinaryGenesList(genesString));
                break;
            case "Double":
                this.targetIndividual = new DoubleIndividualImpl(GeneticAlgorithmUtilsService.getDoubleGenesList(genesString));
                break;
            case "Character":
                this.targetIndividual = new CharIndividualImpl(GeneticAlgorithmUtilsService.getCharacterGenesList(genesString));
                break;
            default:
                throw new UnsupportedOperationException();
        }

    }

   public IIndividual createIndividual() {
       switch (targetIndividualType) {
           case "Integer":
               return new BinaryIndividualImpl(targetIndividual.getGenes());
           case "Double":
               return new DoubleIndividualImpl(targetIndividual.getGenes());
           case "Character":
               return new CharIndividualImpl(targetIndividual.getGenes());
           default:
               throw new UnsupportedOperationException();
       }
   }

    public IIndividual getTargetIndividual() {
        return targetIndividual;
    }
}

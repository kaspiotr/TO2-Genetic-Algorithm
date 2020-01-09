package main.individuals;

import main.utils.GeneticAlgorithmUtilsService;

public class IndividualFactory {

   public static IIndividual createIndividual(String individualType, String genesString) {
       switch (individualType) {
           case "Integer":
               return new BinaryIndividualImpl(GeneticAlgorithmUtilsService.getBinaryGenesList(genesString));
           case "Double":
               return new DoubleIndividualImpl(GeneticAlgorithmUtilsService.getDoubleGenesList(genesString));
           default:
               throw new UnsupportedOperationException();
       }
   }

}

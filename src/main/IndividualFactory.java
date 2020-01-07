package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IndividualFactory {

   public static IIndividual createIndividual(String individualType, String genesString) {
       switch (individualType) {
           case "Integer":
               return new BinaryIndividualImpl(getBinaryGenesList(genesString)).initializeIndividual();
           case "Double":
               return new DoubleIndividualImpl(getDoubleGenesList(genesString)).initializeIndividual();
           default:
               throw new UnsupportedOperationException();
       }
   }

   private static List<Integer> getBinaryGenesList(String genesString) {
        return Arrays.stream(genesString.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
   }

    private static List<Double> getDoubleGenesList(String genesString) {
        return Arrays.stream(genesString.split(","))
                .map(String::trim)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

}

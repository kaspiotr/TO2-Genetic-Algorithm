package main.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeneticAlgorithmUtilsService {

    public static List<Integer> getBinaryGenesList(String genesString) {
        return Arrays.stream(genesString.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Double> getDoubleGenesList(String genesString) {
        return Arrays.stream(genesString.split(","))
                .map(String::trim)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Character> getCharacterGenesList(String genesString) {
        return Arrays.stream(genesString.split(","))
                .map(s -> s.charAt(0))
                .collect(Collectors.toList());
    }

}

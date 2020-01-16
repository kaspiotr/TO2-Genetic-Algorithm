package tests;

import main.utils.GeneticAlgorithmUtilsService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GeneticAlgorithmUtilsServiceTest {

    @Test
    public void getBinaryGenesList() {
        String genesString = "1,1,1,1,0,0,0,0";

        List<Integer> actualGenesList = GeneticAlgorithmUtilsService.getBinaryGenesList(genesString);
        List<Integer> expectedGenesList = Arrays.asList(1, 1, 1, 1, 0, 0, 0, 0);

        assertThat(actualGenesList, is(expectedGenesList));
    }

    @Test
    public void getDoubleGenesList() {
        String genesString = "0.0,0.0,0.0,0.0";

        List<Double> actualGenesList = GeneticAlgorithmUtilsService.getDoubleGenesList(genesString);
        List<Double> expectedGenesList = Arrays.asList(0.0, 0.0, 0.0, 0.0);

        assertThat(actualGenesList, is(expectedGenesList));
    }

    @Test
    public void getCharacterGenesList() {
        String genesString = "A,B,C,D,E,F,G,H";

        List<Character> actualGenesList = GeneticAlgorithmUtilsService.getCharacterGenesList(genesString);
        List<Character> expectedGenesList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

        assertThat(actualGenesList,  is(expectedGenesList));
    }

}
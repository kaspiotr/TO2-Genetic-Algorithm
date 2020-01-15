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
        //given
        String genesString = "1,1,1,1,0,0,0,0";

        //when
        List<Integer> actualGenesList = GeneticAlgorithmUtilsService.getBinaryGenesList(genesString);
        List<Integer> expectedGenesList = Arrays.asList(1, 1, 1, 1, 0, 0, 0, 0);

        //then
        assertThat(actualGenesList, is(expectedGenesList));
    }
}
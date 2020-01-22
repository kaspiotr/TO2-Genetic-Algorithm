package main.individuals;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AbstractIndividualTest {

    @Test
    public void testToString() {
        ArrayList<Character> genes = new ArrayList<>() {
            {
                add('1');
                add('2');
                add('3');
                add('4');
            }
        };

        CharIndividualImpl individual = new CharIndividualImpl(genes);

        assertEquals("1, 2, 3, 4", individual.toString());
    }
}
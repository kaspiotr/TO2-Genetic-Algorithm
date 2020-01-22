package main.individuals;

import org.junit.Test;

import static org.junit.Assert.*;

public class IndividualFactoryTest {
    @Test(expected = UnsupportedOperationException.class)
    public void constructorShouldThrowError() {
        new IndividualFactory("", "");
    }

    @Test
    public void constructorAcceptsInteger() {
        String type = "Integer";
        String genes = "0,1,0,1";

        IndividualFactory factory = new IndividualFactory(type, genes);

        assertEquals(BinaryIndividualImpl.class, factory.getTargetIndividual().getClass());
    }

    @Test
    public void constructorAcceptsDouble() {
        String type = "Double";
        String genes = "1.5,2.5,1.5,1.0";

        IndividualFactory factory = new IndividualFactory(type, genes);

        assertEquals(DoubleIndividualImpl.class, factory.getTargetIndividual().getClass());
    }

    @Test
    public void constructorAcceptsCharacter() {
        String type = "Character";
        String genes = "a,z,v,b";

        IndividualFactory factory = new IndividualFactory(type, genes);

        assertEquals(CharIndividualImpl.class, factory.getTargetIndividual().getClass());
    }

    @Test
    public void createIndividualReturnsBinaryImpl() {
        String type = "Integer";
        String genes = "0,1,0,1";
        IndividualFactory factory = new IndividualFactory(type, genes);

        IIndividual individual = factory.createIndividual();

        assertEquals(BinaryIndividualImpl.class, individual.getClass());
    }

    @Test
    public void createIndividualReturnsDoubleImpl() {
        String type = "Double";
        String genes = "1.5,2.5,1.5,1.0";
        IndividualFactory factory = new IndividualFactory(type, genes);

        IIndividual individual = factory.createIndividual();

        assertEquals(DoubleIndividualImpl.class, individual.getClass());
    }

    @Test
    public void createIndividualReturnsCharImpl() {
        String type = "Character";
        String genes = "a,z,v,b";
        IndividualFactory factory = new IndividualFactory(type, genes);

        IIndividual individual = factory.createIndividual();

        assertEquals(CharIndividualImpl.class, individual.getClass());
    }
}
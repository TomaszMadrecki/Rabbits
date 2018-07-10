import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RabbitFarmTest {

    private RabbitsFarm rabbitsFarm = new RabbitsFarm();

    @Test
    public void given_RabbitsFarm_When_SimulateReproduce_Then_ReturnMonthsToReachLimit() {
        assertEquals(5, rabbitsFarm.simulate(1,3,100));
    }

    @Test
    public void given_NoneRabbitsFarm_When_SimulateReproduction_Then_ReturnMonthsToReachLimit() {
        assertEquals(0, rabbitsFarm.simulate(0, 0, 0));
    }

    @Test
    public void given_MaleRabbitsFarm_When_SimulateReproduction_Then_ReturnMonthsToReachLimit() {
        assertEquals(0, rabbitsFarm.simulate(5,0,5));
    }
}

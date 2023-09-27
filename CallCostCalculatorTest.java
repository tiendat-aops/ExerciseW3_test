import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallCostCalculatorTest {

    @Test
    public void testCalculateCost_Domestic_InvalidTime() {
        assertEquals(-1, CallCostCalculator.calculateCost(-1, "domestic"), 0.001);
    }

    @Test
    public void testCalculateCost_International_InvalidTime() {
        assertEquals(-1, CallCostCalculator.calculateCost(-1, "international"), 0.001);
    }

    @Test
    public void testCalculateCost_DomesticUnder1Minute() {
        assertEquals(1000.0, CallCostCalculator.calculateCost(0.5, "domestic"), 0.001);
    }

    @Test
    public void testCalculateCost_Domestic1To5Minutes() {
        assertEquals(4000.0, CallCostCalculator.calculateCost(2.5, "domestic"), 0.001);
    }

    @Test
    public void testCalculateCost_DomesticOver5Minutes() {
        assertEquals(9000.0, CallCostCalculator.calculateCost(5.75, "domestic"), 0.001);
    }

    @Test
    public void testCalculateCost_InternationalUnder1Minute() {
        assertEquals(1500.0, CallCostCalculator.calculateCost(0.5, "international"), 0.001);
    }

    @Test
    public void testCalculateCost_International1To5Minutes() {
        assertEquals(7500.0, CallCostCalculator.calculateCost(3.25, "international"), 0.001);
    }

    @Test
    public void testCalculateCost_InternationalOver5Minutes() {
        assertEquals(12000.0, CallCostCalculator.calculateCost(5.25, "international"), 0.001);
    }

    @Test
    public void testCalculateCost_InvalidRegion() {
        assertEquals(0.0, CallCostCalculator.calculateCost(5.0, "invalid"), 0.001);
    }
}

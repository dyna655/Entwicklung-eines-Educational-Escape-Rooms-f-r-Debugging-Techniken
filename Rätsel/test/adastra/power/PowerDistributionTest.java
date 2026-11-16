package adastra.power;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

public class PowerDistributionTest {
    private PowerDistribution power;
    private static boolean testPassed = false;

    @BeforeEach void setUp() { power = new PowerDistribution(); }

    @Test
    void testPriorities() {
        assertEquals(1, power.getSectorPriority("BRIDGE"));
        assertEquals(2, power.getSectorPriority("ENGINE"));
        assertEquals(99, power.getSectorPriority("UNKNOWN_SECTOR"), "Unbekannte Sektoren müssen den Standard-Notfallwert 99 liefern!");
        testPassed = true;
    }

    @AfterAll static void key() {
        if (testPassed) {
            byte[] enc = {80, 79, 87, 69, 82, 95, 79, 75};
            System.out.println("ESCAPP-SCHLÜSSEL: " + new String(enc));
        }
    }
}
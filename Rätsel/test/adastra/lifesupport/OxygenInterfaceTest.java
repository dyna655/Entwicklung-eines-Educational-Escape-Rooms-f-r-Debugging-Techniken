package adastra.lifesupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

public class OxygenInterfaceTest {
    private OxygenInterface oxygenInterface;
    private static boolean testPassed = false;

    @BeforeEach void setUp() { oxygenInterface = new OxygenInterface(); }

    @Test
    void testOxygenEvaluation() {
        double flow = oxygenInterface.evaluateOxygenFlow(100, "SECTOR-A");
        assertEquals(155.0, flow, 0.001, "Sauerstoff-Flussrate fehlerhaft. Prüfen Sie Parametertypen und Reihenfolge beim Aufruf!");
        testPassed = true;
    }

    @AfterAll static void key() {
        if (testPassed) {
            byte[] enc = {79, 88, 89, 71, 69, 78, 95, 79, 75};
            System.out.println("ESCAPP-SCHLÜSSEL: " + new String(enc));
        }
    }
}
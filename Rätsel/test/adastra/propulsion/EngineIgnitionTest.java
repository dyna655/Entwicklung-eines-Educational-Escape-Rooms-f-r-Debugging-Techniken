package adastra.propulsion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

public class EngineIgnitionTest {
    private EngineIgnition ignition;
    private static boolean testPassed = false;

    @BeforeEach void setUp() { ignition = new EngineIgnition(); }

    @Test
    void testThrust() {
        int[] stages = {1, 2, 3};
        assertEquals(600, ignition.calculateTotalThrust(stages), "Schubsumme fehlerhaft. Prüfen Sie den Schleifenkopf!");
        testPassed = true;
    }

    @AfterAll static void key() {
        if (testPassed) {
            byte[] enc = {69, 78, 71, 73, 78, 69, 95, 79, 75};
            System.out.println("ESCAPP-SCHLÜSSEL: " + new String(enc));
        }
    }
}
package adastra.gravity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

public class GravityStabilizerTest {
    private GravityStabilizer stab;
    private static boolean testPassed = false;

    @BeforeEach void setUp() { stab = new GravityStabilizer(); }

    @Test
    void testPrecedenceBug() {
        boolean result = stab.validateStabilizer(false, false, true);

        assertFalse(result, "Schwerkraft darf bei inaktivem Reaktor (coreActive = false) nicht allein durch den Override starten!");
        testPassed = true;
    }

    @AfterAll static void key() {
        if (testPassed) {
            byte[] enc = {71, 82, 65, 86, 73, 84, 89, 95, 79, 75};
            System.out.println("ESCAPP-SCHLÜSSEL: " + new String(enc));
        }
    }
}
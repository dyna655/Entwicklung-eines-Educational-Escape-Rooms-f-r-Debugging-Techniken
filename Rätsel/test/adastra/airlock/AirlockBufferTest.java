package adastra.airlock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AirlockBufferTest {
    private AirlockBuffer buffer;
    private static boolean testPassed = false;

    @BeforeEach void setUp() { buffer = new AirlockBuffer(); }

    @Test
    void testHistory() {
        buffer.logPressure(100);
        buffer.logPressure(200);
        List<PressureRecord> hist = buffer.getHistory();

        assertEquals(100, hist.get(0).pressure, "Historische Schleusendaten wurden überschrieben! Fehlt ein 'new'?");
        testPassed = true;
    }

    @AfterAll static void key() {
        if (testPassed) {
            byte[] enc = {65, 73, 82, 76, 79, 67, 75, 95, 79, 75};
            System.out.println("ESCAPP-SCHLÜSSEL: " + new String(enc));
        }
    }
}
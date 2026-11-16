package adastra.reactor;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReactorSafetySystemTest {
    private ReactorSafetySystem safetySystem;
    private static boolean test1Passed = false;
    private static boolean test2Passed = false;
    private static boolean test3Passed = false;
    private static boolean test4Passed = false;

    @BeforeEach
    void setUp() {
        safetySystem = new ReactorSafetySystem();
    }

    @Test
    void test1_StandardRejection() {
        assertFalse(safetySystem.authorizeOverride("CREW", "MONITOR"),
                "Unbefugte Zugriffe müssen abgelehnt werden!");
        test1Passed = true;
    }

    @Test
    void test2_NullSignalHandling() {
        // Bei ausgefallenem Sensor wird null übergeben -> darf keine NullPointerException werfen
        assertDoesNotThrow(() -> {
            boolean result = safetySystem.authorizeOverride(null, "OVERRIDE");
            assertFalse(result, "Null-Werte müssen sicher mit false abgewiesen werden!");
        }, "System stürzt bei null-Referenz ab! Prüfen Sie Kurzschlussoperatoren (&& statt &).");
        test2Passed = true;
    }

    @Test
    void test3_CommanderOverrideWithDynamicStrings() {
        String dynamicLevel = new String("COMMANDER");
        String dynamicCmd = new String("OVERRIDE");

        boolean result = safetySystem.authorizeOverride(dynamicLevel, dynamicCmd);
        assertTrue(result, "Notfallübersteuerung muss mit COMMANDER und OVERRIDE erfolgreich sein!");
        assertTrue(safetySystem.isEmergencyCoolingActive(), "Notfallkühlung muss aktiviert sein!");
        test3Passed = true;
    }

    @Test
    void test4_CoolantThresholdBoundary() {
        // Kritischer Grenzwert: Exakt bei 1200 °C muss die Kühlung bereits auslösen
        boolean triggeredAtThreshold = safetySystem.triggerCoolantInjection(1200);
        assertTrue(triggeredAtThreshold, "Notkühlung muss bereits ab exakt 1200 °C starten!");
        test4Passed = true;
    }

    @AfterAll
    static void onAllTestsPassed() {
        if (test1Passed && test2Passed && test3Passed && test4Passed) {
            byte[] encoded = {89, 84, 95, 49, 51, 48, 48, 95, 82, 69, 65, 67, 84, 79, 82, 95, 79, 75};
            System.out.println("==================================================");
            System.out.println("ALLE TESTS ERFOLGREICH. ESCAPP-CODE: " + new String(encoded));
            System.out.println("==================================================");
        } else {
            System.out.println("WARNUNG: Noch nicht alle Reaktor-Tests bestanden!");
        }
    }
}
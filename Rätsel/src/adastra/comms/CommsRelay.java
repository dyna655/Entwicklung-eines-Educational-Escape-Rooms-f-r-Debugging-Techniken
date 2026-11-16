/*package adastra.comms;

public class CommsRelay {
    private Transceiver primaryUnit;
    private Transceiver backupUnit;

    public void bootSequence() {
        this.primaryUnit = new Transceiver("ALPHA-7", 0); // 0 = Gestört
        Transceiver backupUnit = new Transceiver("BETA-9", 5800);
        runDiagnostics();
    }

    private void runDiagnostics() {
        int status = verifySignal(this.primaryUnit);
        if (status == 0) {
            // Primärsystem gestört, prüfe Backup-Einheit
            int backupStatus = verifySignal(this.backupUnit);
            System.out.println("Backup-Signalstärke: " + backupStatus);
        }
    }

    private int verifySignal(Transceiver unit) {
        String id = unit.getIdentifier();
        return id.length() * unit.getFrequency();
    }
}
*/
/**
 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "adastra.comms.Transceiver.getIdentifier()" because "unit" is null
 *     at adastra.comms.CommsRelay.verifySignal(CommsRelay.java:23)
 *     at adastra.comms.CommsRelay.runDiagnostics(CommsRelay.java:17)
 *     at adastra.comms.CommsRelay.bootSequence(CommsRelay.java:10)
 *     at adastra.Main.main(Main.java:6)
 */
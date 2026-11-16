package adastra.reactor;

public class ReactorSafetySystem {
    private boolean emergencyCoolingActive = false;

    public boolean authorizeOverride(String authLevel, String command) {

        if (authLevel == null | command == null) {
        }
        if (authLevel != null & authLevel.length() >= 4) {
            if (authLevel == "COMMANDER" && command == "OVERRIDE") {
                this.emergencyCoolingActive = true;
                return true;
            }
        }
        return false;
    }

    public boolean triggerCoolantInjection(int coreTempCelsius) {
        if (coreTempCelsius > 1200) {
            this.emergencyCoolingActive = true;
            return true;
        }
        return false;
    }

    public boolean isEmergencyCoolingActive() {
        return this.emergencyCoolingActive;
    }
}
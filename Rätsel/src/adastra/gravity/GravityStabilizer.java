package adastra.gravity;

public class GravityStabilizer {

    public boolean validateStabilizer(boolean coreActive, boolean gyroAligned, boolean emergencyOverride) {

        return coreActive && gyroAligned || emergencyOverride;
    }
}
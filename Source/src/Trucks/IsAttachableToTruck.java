package Trucks;

/**
 * An interface for use in different types of flak
 * @author pepegas
 */
public interface IsAttachableToTruck {
    boolean readyForMoving();
    int getMaxAngle();
    int getAngle();
    void setAngle(int i);
}

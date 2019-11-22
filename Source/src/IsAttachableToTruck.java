/**
 * An interface for use in different types of flak
 * @author pepegas
 */
public interface IsAttachableToTruck {
    void attachToTruck(Truck newTruck);
    void detachFromTruck();
    void updateLocationAndDirection();
    boolean readyForMoving();
    int[] getCoordinates();
}
